package com.tenpo.profit.domain.service;

import com.tenpo.profit.application.ports.input.CalculateProfitUseCase;
import com.tenpo.profit.application.ports.input.GetProfitsUseCase;
import com.tenpo.profit.application.ports.output.GetPercentage;
import com.tenpo.profit.application.ports.output.PercentageCache;
import com.tenpo.profit.application.ports.output.ProfitSQLPersistence;
import com.tenpo.profit.domain.model.Profit;
import com.tenpo.profit.infraestructure.adapters.output.persistence.entity.ProfitE;

import java.util.ArrayList;

public class ProfitService implements CalculateProfitUseCase, GetProfitsUseCase {

    private final GetPercentage percentageRestService;
    private final ProfitSQLPersistence profitSQLPersistence;
    private final PercentageCache percentageCache;

    private static final String PERCENTAGE_CACHE_KEY = "percentage:string";

    public ProfitService(GetPercentage percentageRestService, ProfitSQLPersistence profitSQLPersistence, PercentageCache percentageCache){
        this.percentageRestService = percentageRestService;
        this.profitSQLPersistence =profitSQLPersistence;
        this.percentageCache = percentageCache;
    };

    @Override
    public Profit calculateProfit(int operatorX, int operatorY) {

        var percentage = getPercentage();

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

    private int getPercentage() {

        var percentageValueCatch = percentageCache.get(PERCENTAGE_CACHE_KEY);

        if (percentageValueCatch != null) {
            return Integer.parseInt(percentageValueCatch);
        }

        var percentage = percentageRestService.getIncrementPercentage().getPercentage();
        waitSomeTime();

        percentageCache.save(PERCENTAGE_CACHE_KEY, Integer.toString(percentage));

        return percentage;
    }

    private void waitSomeTime() {
        System.out.println("Long Wait Begin");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Long Wait End");
    }

}
