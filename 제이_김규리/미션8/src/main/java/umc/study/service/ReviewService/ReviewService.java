package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public interface ReviewService {
    ReviewResponseDTO addReview(ReviewRequestDTO request);
    Page<ReviewResponseDTO> getMyReviews(Long memberId, int page);
}