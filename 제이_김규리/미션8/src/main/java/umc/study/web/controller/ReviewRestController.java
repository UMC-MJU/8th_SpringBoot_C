package umc.study.web.controller;

import umc.study.validation.validator.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewService;
import umc.study.validation.validator.ValidPage;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;
    @Operation(summary = "내가 쓴 리뷰 목록 조회 API", description = "내가 쓴 리뷰 목록을 페이징하여 조회합니다. page 쿼리 파라미터를 1 이상으로 전달하세요.")
    @ApiResponse(responseCode = "200", description = "성공")
    @GetMapping("/my")
    public ResponseEntity<Page<ReviewResponseDTO>> getMyReviews(
            @RequestParam("memberId") Long memberId,
            @RequestParam("page") @ValidPage Integer page
    ) {
        Page<ReviewResponseDTO> result = reviewService.getMyReviews(memberId, page);
        return ResponseEntity.ok(result);
    }
}