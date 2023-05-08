package com.tenpo.profit.domain.service;

import com.tenpo.profit.application.ports.input.CalculateProfitUseCase;
import com.tenpo.profit.application.ports.input.GetProfitsUseCase;
import com.tenpo.profit.application.ports.output.GetPercentage;
import com.tenpo.profit.domain.model.Profit;

import java.util.ArrayList;
import java.util.List;

public class ProfitService implements CalculateProfitUseCase, GetProfitsUseCase {

    private final GetPercentage percentageService;

    private List<Profit> profits = new ArrayList<>();

    public ProfitService(GetPercentage percentageService){
        this.percentageService = percentageService;
    };

    @Override
    public Profit calculateProfit(int operatorX, int operatorY) {

        // TODO: check if value in cache else retrieve from percentageService
        // TODO: if retrieve from service then save percentage on cache-db
        var percentage = percentageService.getPercentage().getPercentage();

        var profitCalculated = new Profit(operatorX, operatorY, percentage);

        // TODO: save on sql-db profitCalculated with new thread
        profits.add(profitCalculated);

        return profitCalculated;
    }

    @Override
    public Iterable<Profit> getProfits() {
        return profits;
    }

}
