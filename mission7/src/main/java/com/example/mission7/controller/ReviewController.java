package com.example.mission7.controller;

import com.example.mission7.dto.request.ReviewRequestDto;
import com.example.mission7.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<UUID> writeReview(@RequestBody ReviewRequestDto dto) {
        UUID reviewId = reviewService.writeReview(dto);
        return ResponseEntity.ok(reviewId);
    }
}
