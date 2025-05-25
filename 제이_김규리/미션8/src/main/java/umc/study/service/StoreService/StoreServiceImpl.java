package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public StoreResponseDTO addStore(StoreRequestDTO request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new NoSuchElementException("Region not found"));

        Store store = StoreConverter.toEntity(request.getName(), region);
        Store saved = storeRepository.save(store);

        return StoreConverter.toDTO(saved);
    }
}