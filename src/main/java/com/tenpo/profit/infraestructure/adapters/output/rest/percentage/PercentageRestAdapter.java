package com.tenpo.profit.infraestructure.adapters.output.rest.percentage;

import com.tenpo.profit.application.ports.output.GetPercentage;
import com.tenpo.profit.infraestructure.adapters.output.rest.percentage.data.PercentageDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestTemplate;

//@CacheConfig(cacheNames = "profitCache")
public class PercentageRestAdapter implements GetPercentage {

    RestTemplate client = new RestTemplate();

    public PercentageRestAdapter() {}

    @Override
//    @Cacheable(cacheNames = "profits")
    public PercentageDTO getIncrementPercentage() {

//        return client.getForObject("http://localhost:3000/percentage", PercentageDTO.class);
        return new PercentageDTO(10);

    }
}
