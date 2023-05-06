package com.tenpo.profit.infraestructure.adapters.input.rest;

import com.tenpo.profit.application.ports.input.CalculateProfitUseCase;
import com.tenpo.profit.application.ports.input.GetProfitsUseCase;
import com.tenpo.profit.infraestructure.adapters.input.rest.data.request.ProfitCalculateRequest;
import com.tenpo.profit.infraestructure.adapters.input.rest.data.response.ProfitQueryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/profit")
public class ProfitRestAdapter {
    private final CalculateProfitUseCase calculateProfitUseCase;
    private final GetProfitsUseCase getProfitsUseCase;

    public ProfitRestAdapter(CalculateProfitUseCase calculateProfitUseCase, GetProfitsUseCase getProfitsUseCase) {
        this.calculateProfitUseCase = calculateProfitUseCase;
        this.getProfitsUseCase = getProfitsUseCase;
    }

    @GetMapping
    Iterable<ProfitQueryResponse> getProfits() {

        return getProfitsUseCase.getProfits();
    }

    @PostMapping
        // TODO: revisar el return de esta funcion, quizas deberia tener una clase response aparte de query
    ProfitQueryResponse calculateProfit(@RequestBody ProfitCalculateRequest profit) {
        return calculateProfitUseCase.calculateProfit(profit.getOperatorX(), profit.getOperatorY());
    }

}
