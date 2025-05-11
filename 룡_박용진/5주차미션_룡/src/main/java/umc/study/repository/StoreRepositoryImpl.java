package umc.study.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QRegion;
import umc.study.domain.QStore;
import umc.study.domain.Store;
import umc.study.repository.StoreRepositoryCustom;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        QStore store = QStore.store;
        QRegion region = QRegion.region;

        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(store.name.eq(name));
        }

        if (score != null) {
            predicate.and(store.score.goe(score));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .join(store.region, region).fetchJoin() // ✅ Fetch Join 추가!
                .where(predicate)
                .fetch();
    }
}
