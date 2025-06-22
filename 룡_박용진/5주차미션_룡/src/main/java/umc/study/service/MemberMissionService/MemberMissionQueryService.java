package umc.study.service.MemberMissionService;

import umc.study.web.dto.MemberMissionResponseDTO;

import java.util.List;

public interface MemberMissionQueryService {
    List<MemberMissionResponseDTO> getMyInProgressMissions(Long memberId, int page);
}
