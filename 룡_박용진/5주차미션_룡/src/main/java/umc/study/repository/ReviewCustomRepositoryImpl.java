package umc.study.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import umc.study.domain.Review;

import java.util.List;

@Repository
public class ReviewCustomRepositoryImpl implements ReviewCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Review> findByMemberIdPaged(Long memberId, int offset, int limit) {
        return em.createQuery("SELECT r FROM Review r WHERE r.member.id = :memberId ORDER BY r.createdAt DESC", Review.class)
                .setParameter("memberId", memberId)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
