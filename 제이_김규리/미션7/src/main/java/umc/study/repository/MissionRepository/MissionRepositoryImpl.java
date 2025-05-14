package umc.study.repository.MissionRepository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.QMember;
import umc.study.domain.mapping.QMemberMission;
import umc.study.domain.QMission;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QMember member = QMember.member;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> findInProgressMissions(Long memberId, Long cursor) {
        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .join(memberMission).on(memberMission.mission.eq(mission))
                .join(member).on(memberMission.member.eq(member))
                .where(
                        member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.CHALLENGING),
                        mission.id.lt(cursor)
                )
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<Mission> findCompletedMissions(Long memberId, Long cursor) {
        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .join(memberMission).on(memberMission.mission.eq(mission))
                .join(member).on(memberMission.member.eq(member))
                .where(
                        member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.COMPLETE),
                        mission.id.lt(cursor)
                )
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();
    }
}