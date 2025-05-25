package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.web.dto.ReviewRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody @Valid ReviewRequestDTO requestDTO) {
        reviewCommandService.createReview(requestDTO);
        return ResponseEntity.ok("리뷰 등록 성공");
    }
}
