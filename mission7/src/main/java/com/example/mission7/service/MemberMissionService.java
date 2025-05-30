package com.example.mission7.service;

import com.example.mission7.domain.Member;
import com.example.mission7.domain.MemberMission;
import com.example.mission7.domain.Mission;
import com.example.mission7.domain.MissionStatus;
import com.example.mission7.dto.request.ChallengeMissionRequestDto;
import com.example.mission7.exception.error.ErrorStatus;
import com.example.mission7.handler.TempHandler;
import com.example.mission7.repository.MemberMissionRepository;
import com.example.mission7.repository.MemberRepository;
import com.example.mission7.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberMissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    public UUID challengeMission(ChallengeMissionRequestDto dto) {
        Member member = memberRepository.findById(UUID.fromString("b9c6f69d-e019-4519-a0de-0e6a794afdbc"))
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();

        return memberMissionRepository.save(memberMission).getId();
    }

    public List<MemberMission> getInProgressMissions(UUID memberId) {
        return memberMissionRepository.findAllByMemberIdAndStatus(memberId, "IN_PROGRESS");
    }

    @Transactional
    public void completeMission(UUID memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new RuntimeException("미션이 존재하지 않습니다."));

        if (!"IN_PROGRESS".equals(memberMission.getStatus())) {
            throw new IllegalStateException("이미 완료된 미션입니다.");
        }

        memberMission.setStatus(MissionStatus.COMPLETED);
        memberMissionRepository.save(memberMission);
    }
}
