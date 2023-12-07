package com.istef.demo3addresslocationdb;

import com.istef.demo3addresslocationdb.config.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class Demo3AddressLocationDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo3AddressLocationDbApplication.class, args);
    }

}
