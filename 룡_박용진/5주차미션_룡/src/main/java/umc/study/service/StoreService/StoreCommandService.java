package umc.study.service.StoreService;

import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    void createStore(StoreRequestDTO request);
}