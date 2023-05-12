package com.tenpo.profit.infraestructure.adapters.output.rest.percentage;

import com.tenpo.profit.application.ports.output.GetPercentage;
import com.tenpo.profit.infraestructure.adapters.output.rest.clients.ErrorHandler;
import com.tenpo.profit.infraestructure.adapters.output.rest.clients.Properties;
import com.tenpo.profit.infraestructure.adapters.output.rest.percentage.data.PercentageDTO;
import org.springframework.web.client.RestTemplate;

public class PercentageRestAdapter implements GetPercentage {

    private RestTemplate client;
    private Properties properties;

    public PercentageRestAdapter(Properties properties) {
        this.client = new RestTemplate();
        this.client.setErrorHandler(new ErrorHandler());

        this.properties = properties;
    }

    @Override
    public PercentageDTO getPercentage() {

        var clientResponse = client.getForObject(properties.getBase() + properties.getUrl(), PercentageDTO.class);

        return clientResponse;

    }
}
