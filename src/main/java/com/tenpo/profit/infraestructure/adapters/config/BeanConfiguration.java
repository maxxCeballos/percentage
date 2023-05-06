package com.tenpo.profit.infraestructure.adapters.config;

import com.tenpo.profit.domain.service.ProfitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProfitService profitService() {
        return new ProfitService();
    }
}
