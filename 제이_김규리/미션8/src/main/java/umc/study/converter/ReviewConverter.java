package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Review;
import umc.study.domain.Member;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@Component
public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO dto, Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .title(dto.getTitle())
                .score(dto.getScore())
                .build();
    }

    public static ReviewResponseDTO toResponseDTO(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .title(review.getTitle())
                .score(review.getScore())
                .build();
    }
}