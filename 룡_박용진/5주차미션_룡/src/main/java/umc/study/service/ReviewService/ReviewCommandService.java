package umc.study.service.ReviewService;

import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    void createReview(ReviewRequestDTO request);
}