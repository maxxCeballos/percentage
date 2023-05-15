package com.tenpo.profit.application.ports.output;

import com.tenpo.profit.domain.model.Profit;
import com.tenpo.profit.infraestructure.adapters.output.persistence.entity.ProfitE;

import java.util.concurrent.CompletableFuture;

public interface ProfitSQLPersistence {

    CompletableFuture<Boolean> saveProfit(Profit profit);

    Iterable<ProfitE> getProfits(int pageNo, int pageSize);
}
