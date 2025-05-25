package com.example.mission7.repository;

import com.example.mission7.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MissionRepository extends JpaRepository<Mission, UUID> {
}
