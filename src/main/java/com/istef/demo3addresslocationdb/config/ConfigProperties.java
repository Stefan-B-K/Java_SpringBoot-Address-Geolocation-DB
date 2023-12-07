package com.istef.demo3addresslocationdb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("demo3")
public record ConfigProperties(String googleApisUrl, String googleGeocodingKey) {
}
