package com.tenpo.profit.application.ports.input;

import com.tenpo.profit.infraestructure.adapters.input.rest.data.response.ProfitQueryResponse;

public interface CalculateProfitUseCase {

    ProfitQueryResponse calculateProfit(int operatorX, int operatorY);
}
