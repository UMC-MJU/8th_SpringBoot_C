package umc.study.service.MissionService;

import umc.study.web.dto.MyMissionRequestDTO;

public interface MyMissionCommandService {
    void challengeMission(Long missionId, MyMissionRequestDTO request);
}