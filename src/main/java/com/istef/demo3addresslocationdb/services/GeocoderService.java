package com.istef.demo3addresslocationdb.services;

import com.istef.demo3addresslocationdb.config.ConfigProperties;
import com.istef.demo3addresslocationdb.entities.Site;
import com.istef.demo3addresslocationdb.json.Response;
import com.istef.demo3addresslocationdb.json.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class GeocoderService {

    private final ConfigProperties configProps;

    private final WebClient client;

    @Autowired
    public GeocoderService(WebClient.Builder builder,
                           ConfigProperties configProps) {
        client = builder.baseUrl(configProps.googleApisUrl()).build();
        this.configProps = configProps;
    }

    public Site getLatLng(String... address) {
        String encoded = Stream.of(address)
                .map(s -> URLEncoder.encode(s, StandardCharsets.UTF_8))
                .collect(Collectors.joining(","));
        String path = "/maps/api/geocode/json";
        Response response = client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam("address", encoded)
                        .queryParam("key", configProps.googleGeocodingKey())
                        .build()
                )
                .retrieve()
                .bodyToMono(Response.class)
                .block(Duration.ofSeconds(2));
        Optional<Result> result = response.results().stream().findFirst();
        return result.map(value -> new Site(value.formattedAddress(),
                        value.geometry().location().lat(),
                        value.geometry().location().lng()))
                .orElse(null);
    }
}
