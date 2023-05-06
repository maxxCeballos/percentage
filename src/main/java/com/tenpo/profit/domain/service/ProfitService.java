package com.tenpo.profit.domain.service;

import com.tenpo.profit.application.ports.input.CalculateProfitUseCase;
import com.tenpo.profit.application.ports.input.GetProfitsUseCase;
import com.tenpo.profit.infraestructure.adapters.input.rest.data.response.ProfitQueryResponse;

import java.util.ArrayList;
import java.util.List;

public class ProfitService implements CalculateProfitUseCase, GetProfitsUseCase {

    private List<ProfitQueryResponse> profits = new ArrayList<>();

    public ProfitService(){};

    @Override
    // TODO: desacoplar ProfitQueryResponse, crear clase de domain logic
    public ProfitQueryResponse calculateProfit(int operatorX, int operatorY) {
        var profitCalculated = new ProfitQueryResponse(operatorX, operatorY, 10.0f);
        profits.add(profitCalculated);
        return profitCalculated;
    }

    @Override
    public Iterable<ProfitQueryResponse> getProfits() {
        return profits;
    }

}
