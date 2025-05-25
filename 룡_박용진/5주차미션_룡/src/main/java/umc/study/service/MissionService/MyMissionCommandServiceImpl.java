package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;

import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MyMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MyMissionCommandServiceImpl implements MyMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public void challengeMission(Long missionId, MyMissionRequestDTO request) {
        Long memberId = 1L; // 하드코딩된 사용자 ID

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("미션이 존재하지 않습니다."));

        // 중복 도전 여부는 커스텀 어노테이션에서 검증함
        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(request.getStatus())
                .build();

        memberMissionRepository.save(memberMission);
    }
}
