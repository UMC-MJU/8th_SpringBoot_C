package umc.study.repository.MissionRepository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.study.domain.*;
import umc.study.domain.mapping.QMemberMission;
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
    @Override
    public Page<Mission> findAllByStore(Store storeEntity, Pageable pageable) {
        List<Mission> content = jpaQueryFactory
                .selectFrom(mission)
                .where(mission.store.eq(storeEntity))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = jpaQueryFactory
                .selectFrom(mission)
                .where(mission.store.eq(storeEntity))
                .fetchCount();

        return new PageImpl<>(content, pageable, total);
    }
}