package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MissionStatus;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.web.dto.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<MemberMissionResponseDTO> getMyInProgressMissions(Long memberId, int page) {

        memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Page<MemberMission> result = memberMissionRepository
                .findAllByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, PageRequest.of(page, 10));

        return result.stream()
                .map(mm -> MemberMissionResponseDTO.builder()
                        .missionId(mm.getMission().getId())
                        .content(mm.getMission().getMissionSpec())
                        .point(mm.getMission().getReward())
                        .status(mm.getStatus().name())
                        .build())
                .collect(Collectors.toList());
    }
}
