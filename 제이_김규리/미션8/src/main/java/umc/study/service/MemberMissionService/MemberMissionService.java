package umc.study.service.MemberMissionService;

import umc.study.web.dto.StoreMissionRequestDTO;
import umc.study.web.dto.StoreMissionResponseDTO;

import java.util.List;

public interface MemberMissionService {
    StoreMissionResponseDTO challengeMission(StoreMissionRequestDTO request);
    List<StoreMissionResponseDTO> getInProgressMissions(Long memberId, Long cursor);

}