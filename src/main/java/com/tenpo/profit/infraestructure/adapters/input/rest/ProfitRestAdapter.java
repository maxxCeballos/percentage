package com.tenpo.profit.infraestructure.adapters.input.rest;

import com.tenpo.profit.infraestructure.adapters.input.rest.data.request.ProfitCalculateRequest;
import com.tenpo.profit.infraestructure.adapters.input.rest.data.response.ProfitQueryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/profit")
public class ProfitRestAdapter {
    private List<ProfitQueryResponse> profits = new ArrayList<>();

    @GetMapping
    Iterable<ProfitQueryResponse> getProfits() {
        return profits;
    }

    @PostMapping
    ProfitQueryResponse calculateProfit(@RequestBody ProfitCalculateRequest profit) {
        var profitCalculated = new ProfitQueryResponse(profit.getOperatorX(), profit.getOperatorY(), 10.0f);
        profits.add(profitCalculated);
        return profitCalculated;
    }

}
