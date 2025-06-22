// ReviewRestController.java

package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    // [GET] 내가 작성한 리뷰 목록 조회
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<ReviewResponseDTO>> getMyReviews(
            @PathVariable Long memberId,
            @RequestParam(defaultValue = "1") int page) {

        List<ReviewResponseDTO> result = reviewQueryService.getReviewsByMemberId(memberId, page - 1);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody @Valid ReviewRequestDTO requestDTO) {
        reviewCommandService.createReview(requestDTO);
        return ResponseEntity.ok("리뷰 등록 성공");
    }
}
