package com.istef.demo3addresslocationdb.controllers;


import com.istef.demo3addresslocationdb.entities.Site;
import com.istef.demo3addresslocationdb.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sites")
public class SiteController {

    private SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping
    public List<Site> getAll() {
        return siteService.findAllSites();
    }

    @GetMapping("{id}")
    public ResponseEntity<Site> getById(@PathVariable Integer id) {
        return ResponseEntity.of(siteService.findSiteById(id));
    }

    @PostMapping
    public ResponseEntity<Site> saveSite(@RequestParam String address) {
        Site site = siteService.saveSite(address);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id")
                .buildAndExpand(site.getId())
                .toUri();
        return ResponseEntity.created(uri).body(site);
    }
}
