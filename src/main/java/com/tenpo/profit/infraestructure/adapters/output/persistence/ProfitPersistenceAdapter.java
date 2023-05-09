package com.tenpo.profit.infraestructure.adapters.output.persistence;

import com.tenpo.profit.application.ports.output.ProfitSQLPersistence;
import com.tenpo.profit.domain.model.Profit;
import com.tenpo.profit.infraestructure.adapters.output.persistence.entity.ProfitE;
import com.tenpo.profit.infraestructure.adapters.output.persistence.repository.ProfitRepository;


public class ProfitPersistenceAdapter implements ProfitSQLPersistence {

    private final ProfitRepository profitRepository;

    public ProfitPersistenceAdapter(ProfitRepository profitRepository) {
        this.profitRepository = profitRepository;
    }

    @Override
    public void saveProfit(Profit profit) {
        var profitEntity = new ProfitE(profit.getId(), profit.getOperatorX(), profit.getOperatorY(), profit.getPercentage(), profit.getTotal());
        var profitSaved = profitRepository.save(profitEntity);
        var message = "el total del profit saved is " + profitSaved;
        System.out.println(message);
    }

    @Override
    public Iterable<ProfitE> getProfits() {
        return profitRepository.findAll();
    }
}
