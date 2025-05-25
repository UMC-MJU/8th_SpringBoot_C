package com.example.mission7.service;

import com.example.mission7.domain.Member;
import com.example.mission7.domain.Review;
import com.example.mission7.domain.Store;
import com.example.mission7.dto.request.ReviewRequestDto;
import com.example.mission7.exception.error.ErrorStatus;
import com.example.mission7.handler.TempHandler;
import com.example.mission7.repository.MemberRepository;
import com.example.mission7.repository.ReviewRepository;
import com.example.mission7.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    public UUID writeReview(ReviewRequestDto dto) {
        Member member = memberRepository.findFirstByOrderByCreatedAtAsc()
                .orElseThrow(() -> new TempHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.STORE_NOT_FOUND));

        Review review = Review.builder()
                .store(store)
                .member(member)
                .content(dto.getContent())
                .score(dto.getRating())
                .build();

        return reviewRepository.save(review).getId();
    }
}

