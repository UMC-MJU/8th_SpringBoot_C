package com.example.mission7.repository;


import com.example.mission7.domain.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.UUID;

public interface MemberMissionRepository extends JpaRepository<MemberMission, UUID> {
    @Modifying
    void deleteByMemberId(UUID memberId);}
