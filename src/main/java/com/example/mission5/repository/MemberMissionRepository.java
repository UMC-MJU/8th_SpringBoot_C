package com.example.mission5.repository;

import com.example.demo.domain.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.UUID;

public interface MemberMissionRepository extends JpaRepository<MemberMission, UUID> {
    @Modifying
    void deleteByMemberId(UUID memberId);}
