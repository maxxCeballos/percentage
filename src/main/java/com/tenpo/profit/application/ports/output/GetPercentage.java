package com.tenpo.profit.application.ports.output;

import com.tenpo.profit.infraestructure.adapters.output.rest.percentage.data.PercentageDTO;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public interface GetPercentage {

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000))
    PercentageDTO getPercentage();
}
