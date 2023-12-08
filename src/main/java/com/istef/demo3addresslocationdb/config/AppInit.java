package com.istef.demo3addresslocationdb.config;

import com.istef.demo3addresslocationdb.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {

    private final SiteService siteService;

    @Autowired
    public AppInit(SiteService siteService) {
        this.siteService = siteService;
    }

    @Override
    public void run(String... args) {
        siteService.initializeDB();
    }
}
