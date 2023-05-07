package com.tenpo.profit.domain.service;

import com.tenpo.profit.application.ports.input.CalculateProfitUseCase;
import com.tenpo.profit.application.ports.input.GetProfitsUseCase;
import com.tenpo.profit.domain.model.Profit;

import java.util.ArrayList;
import java.util.List;

public class ProfitService implements CalculateProfitUseCase, GetProfitsUseCase {

    private List<Profit> profits = new ArrayList<>();

    public ProfitService(){};

    @Override
    public Profit calculateProfit(int operatorX, int operatorY) {
        var profitCalculated = new Profit(operatorX, operatorY, 10);
        profits.add(profitCalculated);
        return profitCalculated;
    }

    @Override
    public Iterable<Profit> getProfits() {
        return profits;
    }

}
