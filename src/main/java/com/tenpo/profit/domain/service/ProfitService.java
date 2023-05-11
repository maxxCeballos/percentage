package com.tenpo.profit.domain.service;

import com.tenpo.profit.application.ports.input.CalculateProfitUseCase;
import com.tenpo.profit.application.ports.input.GetProfitsUseCase;
import com.tenpo.profit.application.ports.output.GetPercentage;
import com.tenpo.profit.application.ports.output.ProfitSQLPersistence;
import com.tenpo.profit.domain.model.Profit;
import com.tenpo.profit.infraestructure.adapters.input.rest.data.response.ProfitQueryResponse;
import com.tenpo.profit.infraestructure.adapters.output.persistence.entity.ProfitE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;

public class ProfitService implements CalculateProfitUseCase, GetProfitsUseCase {

    @Autowired
    private RedisTemplate<String, String> template;
    private static final String PERCENTAGE_CACHE_KEY = "last:percentage";

    private final GetPercentage percentageRestService;
    private final ProfitSQLPersistence profitSQLPersistence;

    public ProfitService(GetPercentage percentageRestService, ProfitSQLPersistence profitSQLPersistence){
        this.percentageRestService = percentageRestService;
        this.profitSQLPersistence =profitSQLPersistence;
    };

    @Override
    public Profit calculateProfit(int operatorX, int operatorY) {

        // TODO: check if value in cache else retrieve from percentageService
        // TODO: if retrieve from service then save percentage on cache-db
        var percentage = percentageRestService.getIncrementPercentage().getPercentage();
        template.opsForValue().set(PERCENTAGE_CACHE_KEY, Integer.toString(percentage));

        var profitCalculated = new Profit(operatorX, operatorY, percentage);

        // TODO: save on sql-db profitCalculated with new thread
        profitSQLPersistence.saveProfit(profitCalculated);

        return profitCalculated;
    }

    @Override
    public Iterable<Profit> getProfits() {

        var profitsEntities = profitSQLPersistence.getProfits();

        var response = new ArrayList<Profit>();

        for (ProfitE p: profitsEntities) {
            response.add(new Profit(p.getId(), p.getOperatorX(), p.getOperatorY(), p.getPercentage(), p.getTotal()));
        }

        return response;
    }

}
