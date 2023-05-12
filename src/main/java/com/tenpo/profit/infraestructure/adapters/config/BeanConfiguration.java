package com.tenpo.profit.infraestructure.adapters.config;

import com.tenpo.profit.application.ports.output.PercentageCache;
import com.tenpo.profit.application.ports.output.ProfitSQLPersistence;
import com.tenpo.profit.domain.service.ProfitService;
import com.tenpo.profit.infraestructure.adapters.output.cache.PercentageCacheAdapter;
import com.tenpo.profit.infraestructure.adapters.output.persistence.ProfitPersistenceAdapter;
import com.tenpo.profit.infraestructure.adapters.output.persistence.repository.ProfitRepository;
import com.tenpo.profit.infraestructure.adapters.output.rest.percentage.PercentageRestAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    PercentageCacheAdapter percentageCacheAdapter() {
        return new PercentageCacheAdapter();
    }

    @Bean
    PercentageRestAdapter percentageServiceAdapter() {
        return new PercentageRestAdapter();
    }

    @Bean
    ProfitPersistenceAdapter profitPersistenceAdapter(ProfitRepository profitRepository) { return new ProfitPersistenceAdapter(profitRepository); }

    @Bean
    ProfitService profitService(PercentageRestAdapter percentageServiceAdapter, ProfitSQLPersistence profitSQLPersistence, PercentageCache percentageCache) {

        return new ProfitService(percentageServiceAdapter, profitSQLPersistence, percentageCache);
    }
}
