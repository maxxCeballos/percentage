package com.tenpo.profit.application.ports.output;

import com.tenpo.profit.domain.model.Profit;
import com.tenpo.profit.infraestructure.adapters.output.persistence.entity.ProfitE;

public interface ProfitSQLPersistence {

    void saveProfit(Profit profit);

    Iterable<ProfitE> getProfits();
}
