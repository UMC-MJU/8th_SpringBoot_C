package umc.study.service.StoreService;

import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public interface StoreService {
    StoreResponseDTO addStore(StoreRequestDTO request);
}