package com.example.demo.repository;

import com.example.demo.domain.MemberPrefer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.UUID;

public interface MemberPreferRepository extends JpaRepository<MemberPrefer, UUID> {
    @Modifying
    void deleteByMemberId(UUID memberId);
}
