package com.tenpo.profit.application.ports.input;

import com.tenpo.profit.domain.model.Profit;

public interface CalculateProfitUseCase {

    Profit calculateProfit(int operatorX, int operatorY);
}
