package com.example.mission7.web;

import com.example.mission7.domain.Member;
import com.example.mission7.repository.MemberMissionRepository;
import com.example.mission7.repository.MemberRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NotChallengedMissionValidator implements ConstraintValidator<NotChallengedMission, UUID> {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(UUID missionId, ConstraintValidatorContext context) {
        Member hardcodedMember = memberRepository.findById(UUID.fromString("b9c6f69d-e019-4519-a0de-0e6a794afdbc"))
                .orElseThrow(() -> new RuntimeException("Member not found"));

        if (hardcodedMember == null) {
            return true;
        }

        return !memberMissionRepository.existsByMemberAndMissionId(hardcodedMember, missionId);
    }
}
