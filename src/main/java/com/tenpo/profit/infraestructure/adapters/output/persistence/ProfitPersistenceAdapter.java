package com.tenpo.profit.infraestructure.adapters.output.persistence;

import com.tenpo.profit.application.ports.output.ProfitSQLPersistence;
import com.tenpo.profit.domain.model.Profit;
import com.tenpo.profit.infraestructure.adapters.output.persistence.entity.ProfitE;
import com.tenpo.profit.infraestructure.adapters.output.persistence.repository.ProfitRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;


public class ProfitPersistenceAdapter implements ProfitSQLPersistence {

    private final ProfitRepository profitRepository;

    public ProfitPersistenceAdapter(ProfitRepository profitRepository) {
        this.profitRepository = profitRepository;
    }

    @Override
    @Async
    public CompletableFuture<Boolean> saveProfit(Profit profit) {

        try {
            Thread.sleep(10000L);
            var profitEntity = new ProfitE(profit.getId(), profit.getOperatorX(), profit.getOperatorY(), profit.getPercentage(), profit.getTotal());
            var profitSaved = profitRepository.save(profitEntity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public Iterable<ProfitE> getProfits(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);

        return profitRepository.findAll(paging);
    }
}
