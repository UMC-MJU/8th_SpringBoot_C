package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStatus;
import umc.study.repository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public void completeMission(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository
                .findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원의 미션이 존재하지 않습니다."));

        if (memberMission.getStatus() == MissionStatus.COMPLETE) {
            throw new IllegalStateException("이미 완료된 미션입니다.");
        }

        memberMission.setStatus(MissionStatus.COMPLETE);  // 상태 변경
    }
}
