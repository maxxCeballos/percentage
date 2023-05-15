package com.tenpo.profit.infraestructure.adapters.config;

import com.tenpo.profit.application.ports.output.GetPercentage;
import com.tenpo.profit.application.ports.output.PercentageCache;
import com.tenpo.profit.application.ports.output.ProfitSQLPersistence;
import com.tenpo.profit.domain.service.ProfitService;
import com.tenpo.profit.infraestructure.adapters.output.cache.PercentageCacheAdapter;
import com.tenpo.profit.infraestructure.adapters.output.persistence.ProfitPersistenceAdapter;
import com.tenpo.profit.infraestructure.adapters.output.persistence.repository.ProfitRepository;
import com.tenpo.profit.infraestructure.adapters.output.rest.clients.Properties;
import com.tenpo.profit.infraestructure.adapters.output.rest.percentage.PercentageRestAdapter;
import com.tenpo.profit.infraestructure.adapters.output.rest.percentage.data.PercentageDTO;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.when;

@Configuration
public class BeanConfiguration {

    @Bean
    PercentageCacheAdapter percentageCacheAdapter() {
        return new PercentageCacheAdapter();
    }

    @Bean
    PercentageRestAdapter percentageServiceAdapter() throws Exception {
        PercentageRestAdapter remoteService = Mockito.mock(PercentageRestAdapter.class);

        when(remoteService.getPercentage())
                .thenThrow(new RuntimeException("Remote Exception 1"))
                .thenThrow(new RuntimeException("Remote Exception 2"))
                .thenReturn(new PercentageDTO(10));
        
        return remoteService;
    }

    @Bean
    ProfitPersistenceAdapter profitPersistenceAdapter(ProfitRepository profitRepository) { return new ProfitPersistenceAdapter(profitRepository); }

    @Bean
    ProfitService profitService(PercentageRestAdapter percentageServiceAdapter, ProfitSQLPersistence profitSQLPersistence, PercentageCache percentageCache) {

        return new ProfitService(percentageServiceAdapter, profitSQLPersistence, percentageCache);
    }
}
