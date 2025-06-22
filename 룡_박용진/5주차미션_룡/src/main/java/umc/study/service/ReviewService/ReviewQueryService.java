// ReviewQueryService.java

package umc.study.service.ReviewService;

import umc.study.web.dto.ReviewResponseDTO;
import java.util.List;

public interface ReviewQueryService {
    List<ReviewResponseDTO> getReviewsByMemberId(Long memberId, int page);
}
