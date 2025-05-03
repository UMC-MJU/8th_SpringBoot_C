package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
}
