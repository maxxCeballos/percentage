package com.tenpo.profit.application.ports.output;

import com.tenpo.profit.infraestructure.adapters.output.rest.percentage.data.PercentageDTO;

public interface GetPercentage {

    PercentageDTO getIncrementPercentage();
}
