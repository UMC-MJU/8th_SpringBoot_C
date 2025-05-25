package com.example.mission7.repository;

import com.example.mission7.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RegionRepository extends JpaRepository<Region, UUID> {
    Optional<Region> findByName(String name);
}

