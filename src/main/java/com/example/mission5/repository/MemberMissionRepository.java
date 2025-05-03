package com.example.demo.repository;

import com.example.demo.domain.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MemberMissionRepository extends JpaRepository<MemberMission, UUID> {
    @Modifying
    void deleteByMemberId(UUID memberId);}
