package com.example.mission7.repository;


import com.example.mission7.domain.Member;
import com.example.mission7.domain.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberMissionRepository extends JpaRepository<MemberMission, UUID> {
    @Modifying
    void deleteByMemberId(UUID memberId);

    boolean existsByMemberAndMissionId(Member hardcodedMember, UUID missionId);
    Optional<MemberMission> findById(UUID id);

    List<MemberMission> findAllByMemberIdAndStatus(UUID memberId, String inProgress);
}
