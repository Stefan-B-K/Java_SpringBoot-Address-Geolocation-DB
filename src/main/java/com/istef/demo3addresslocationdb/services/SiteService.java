package com.istef.demo3addresslocationdb.services;


import com.istef.demo3addresslocationdb.dao.SiteRepository;
import com.istef.demo3addresslocationdb.entities.Site;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SiteService {
    private final GeocoderService geocoderService;
    private final SiteRepository repository;

    @Autowired
    public SiteService(GeocoderService geocoderService, SiteRepository repository) {
        this.geocoderService = geocoderService;
        this.repository = repository;
    }

    private Site fillInLocation(Site site) {
        return geocoderService.getLatLng(site.getAddress());
    }

    public void initializeDB() {
        repository.saveAll(List.of(
                fillInLocation(new Site("Boston, MA")),
                fillInLocation(new Site("Framingham, MA")),
                fillInLocation(new Site("Waltham, MA")))
        ).forEach(System.out::println);
    }

    public List<Site> findAllSites() {
        return repository.findAll();
    }

    public Optional<Site> findSiteById(Integer id) {
        return repository.findById(id);
    }

    public Site saveSite(String address) {
        return repository.save(fillInLocation(new Site(address)));
    }


}
