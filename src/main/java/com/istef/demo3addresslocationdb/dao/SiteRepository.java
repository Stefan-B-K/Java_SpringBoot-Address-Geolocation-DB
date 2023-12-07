package com.istef.demo3addresslocationdb.dao;

import com.istef.demo3addresslocationdb.entities.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Integer> {
}
