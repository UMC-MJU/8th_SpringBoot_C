package umc.study.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.domain.mapping.MissionStatus;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId); // 중복 도전 여부 확인용
    Page<MemberMission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable);
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);


}
