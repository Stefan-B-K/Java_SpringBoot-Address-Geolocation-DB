package com.istef.demo3addresslocationdb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "google-apis")
@Component
public class GoogleApisConfig {

    private String url;
    private String geocodingKey;


    public String getGeocodingKey() {
        return geocodingKey;
    }

    public void setGeocodingKey(String geocodingKey) {
        this.geocodingKey = geocodingKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
