package com.example.mission7.repository;

import com.example.mission7.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findFirstByOrderByCreatedAtAsc();
    Optional<Member> findById(UUID id);
}
