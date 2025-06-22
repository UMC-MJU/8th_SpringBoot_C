package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Region;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public void createStore(StoreRequestDTO request) {
        Region region = regionRepository.findById(request.getRegion_id())
                .orElseThrow(() -> new IllegalArgumentException("해당 지역이 존재하지 않습니다."));

        Store store = Store.builder()
                .name(request.getName())
                .region(region)
                .build();

        storeRepository.save(store);
    }

    }

