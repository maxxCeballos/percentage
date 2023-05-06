package com.tenpo.profit.application.ports.input;

import com.tenpo.profit.infraestructure.adapters.input.rest.data.response.ProfitQueryResponse;

public interface GetProfitsUseCase {

    Iterable<ProfitQueryResponse> getProfits();
}
