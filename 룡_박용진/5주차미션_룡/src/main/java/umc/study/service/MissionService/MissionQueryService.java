package umc.study.service.MissionService;

import umc.study.web.dto.MissionResponseDTO;

import java.util.List;

public interface MissionQueryService {
    List<MissionResponseDTO> getMissionsByStoreId(Long storeId, int page);
}

