package com.stronghaul.sitebid.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "trailer")
public class TrailerConfig {

    private Double maxPayload;

    public Double getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(Double maxPayload) {
        this.maxPayload = maxPayload;
    }
}
