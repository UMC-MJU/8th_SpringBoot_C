package com.example.mission7.service;

import com.example.mission7.domain.Mission;
import com.example.mission7.domain.Store;
import com.example.mission7.dto.request.MissionRequestDto;
import com.example.mission7.repository.MissionRepository;
import com.example.mission7.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    public UUID addMission(MissionRequestDto dto) {
        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Mission mission = Mission.builder()
                .store(store)
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .mission_spec(dto.getMissionSpec())
                .build();

        return missionRepository.save(mission).getId();
    }

    public List<Mission> getMissionsByStore(UUID storeId) {
        return missionRepository.findAllByStoreId(storeId);
    }
}
