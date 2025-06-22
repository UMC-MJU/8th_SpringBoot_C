// ReviewQueryServiceImpl.java

package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewResponseDTO> getReviewsByMemberId(Long memberId, int page) {
        int pageSize = 10;
        Page<Review> reviewPage = reviewRepository.findAllByMemberId(memberId, PageRequest.of(page, pageSize));
        List<Review> reviews = reviewPage.getContent();

        return reviews.stream()
                .map(review -> ReviewResponseDTO.builder()
                        .reviewId(review.getId())
                        .title(review.getTitle())
                        .body(review.getBody())
                        .score(review.getScore())
                        .memberId(review.getMember().getId())
                        .storeId(review.getStore().getId())
                        .build())
                .collect(Collectors.toList());
    }

}
