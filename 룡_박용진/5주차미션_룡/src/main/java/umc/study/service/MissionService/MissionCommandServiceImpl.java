package umc.study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.Store;

import umc.study.repository.MissionRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public void createMission(Long storeId, MissionRequestDTO request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Mission mission = Mission.builder()
                .missionSpec(request.getMissionSpec())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .store(store)
                .build();

        missionRepository.save(mission);
    }
}