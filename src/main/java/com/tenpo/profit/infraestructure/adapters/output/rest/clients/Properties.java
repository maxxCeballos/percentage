package com.tenpo.profit.infraestructure.adapters.output.rest.clients;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="fee-service")
@Data
public class Properties {

    private String base;
    private String url;

}
