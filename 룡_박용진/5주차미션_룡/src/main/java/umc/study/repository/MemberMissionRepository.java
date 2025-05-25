package umc.study.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId); // 중복 도전 여부 확인용
}
