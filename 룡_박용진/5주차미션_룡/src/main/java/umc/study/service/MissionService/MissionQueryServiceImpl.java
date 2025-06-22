package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public List<MissionResponseDTO> getMissionsByStoreId(Long storeId, int page) {
        int pageSize = 10;
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Page<Mission> missions = missionRepository.findAllByStore(store, PageRequest.of(page, pageSize));

        return missions.stream()
                .map(mission -> MissionResponseDTO.builder()
                        .missionId(mission.getId())
                        .content(mission.getMissionSpec())
                        .point(mission.getReward())
                        .build())
                .collect(Collectors.toList());
    }
}
