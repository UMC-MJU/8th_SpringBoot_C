package umc.study.service.MissionService;

import umc.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    void createMission(Long storeId, MissionRequestDTO request);
}
