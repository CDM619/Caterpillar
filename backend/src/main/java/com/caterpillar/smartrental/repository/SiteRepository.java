package com.caterpillar.smartrental.repository;

import com.caterpillar.smartrental.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Long> {
}