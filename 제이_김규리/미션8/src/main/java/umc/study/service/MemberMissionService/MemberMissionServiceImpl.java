package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.web.dto.StoreMissionRequestDTO;
import umc.study.web.dto.StoreMissionResponseDTO;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public StoreMissionResponseDTO challengeMission(StoreMissionRequestDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new NoSuchElementException("Member not found"));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new NoSuchElementException("Mission not found"));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();

        MemberMission saved = memberMissionRepository.save(memberMission);

        return StoreMissionResponseDTO.builder()
                .memberMissionId(saved.getId())
                .memberId(saved.getMember().getId())
                .missionId(saved.getMission().getId())
                .status(saved.getStatus().name())
                .build();
    }
}