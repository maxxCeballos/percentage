package com.tenpo.profit.infraestructure.adapters.output.percentage.service;

import com.tenpo.profit.application.ports.output.GetPercentage;
import org.springframework.web.client.RestTemplate;

public class PercentageServiceAdapter implements GetPercentage {

    RestTemplate client = new RestTemplate();

    public PercentageServiceAdapter() {}

    public PercentageDTO getPercentage() {

        return client.getForObject("http://localhost:3000/percentage", PercentageDTO.class);

    }
}
