package umc.study.repository;

import umc.study.domain.Review;

import java.util.List;

public interface ReviewCustomRepository {
    List<Review> findByMemberIdPaged(Long memberId, int offset, int limit);
}

