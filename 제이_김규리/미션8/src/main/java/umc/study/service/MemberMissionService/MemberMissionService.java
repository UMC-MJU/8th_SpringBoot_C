package umc.study.service.MemberMissionService;

import umc.study.web.dto.StoreMissionRequestDTO;
import umc.study.web.dto.StoreMissionResponseDTO;

public interface MemberMissionService {
    StoreMissionResponseDTO challengeMission(StoreMissionRequestDTO request);
}