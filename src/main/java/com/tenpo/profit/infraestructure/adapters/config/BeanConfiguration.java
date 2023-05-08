package com.tenpo.profit.infraestructure.adapters.config;

import com.tenpo.profit.domain.service.ProfitService;
import com.tenpo.profit.infraestructure.adapters.output.percentage.service.PercentageServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PercentageServiceAdapter percentageServiceAdapter() {
        return new PercentageServiceAdapter();
    }

    @Bean
    public ProfitService profitService(PercentageServiceAdapter percentageServiceAdapter) {

        return new ProfitService(percentageServiceAdapter);
    }
}
