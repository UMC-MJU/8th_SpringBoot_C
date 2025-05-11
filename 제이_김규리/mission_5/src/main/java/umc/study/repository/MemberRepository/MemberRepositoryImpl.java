package umc.study.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.Member;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public Member findMemberById(Long memberId) {
        return jpaQueryFactory
                .select(member.id, member.name, member.email, member.phoneNum, member.point)
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}