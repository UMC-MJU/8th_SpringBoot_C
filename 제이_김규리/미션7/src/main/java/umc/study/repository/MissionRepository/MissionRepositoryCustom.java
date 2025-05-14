package umc.study.repository.MissionRepository;

import umc.study.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findInProgressMissions(Long memberId, Long cursor);
    List<Mission> findCompletedMissions(Long memberId, Long cursor);
}