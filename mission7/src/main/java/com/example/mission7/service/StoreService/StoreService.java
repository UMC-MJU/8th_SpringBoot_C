package com.example.mission7.service.StoreService;

import com.example.mission7.domain.Region;
import com.example.mission7.domain.Store;
import com.example.mission7.dto.request.StoreRequestDto;
import com.example.mission7.repository.RegionRepository;
import com.example.mission7.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    public UUID addStore(StoreRequestDto dto) {

        Region region = regionRepository.findByName(dto.getRegion())
                .orElseThrow(() -> new RuntimeException("Region not found: " + dto.getRegion()));

        Store store = Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .region(region)
                .build();
        return storeRepository.save(store).getId();
    }
}

