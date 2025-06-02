package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.Mission;
import umc.study.domain.Store;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findInProgressMissions(Long memberId, Long cursor);
    List<Mission> findCompletedMissions(Long memberId, Long cursor);

    Page<Mission> findAllByStore(Store store, Pageable pageable);
}
