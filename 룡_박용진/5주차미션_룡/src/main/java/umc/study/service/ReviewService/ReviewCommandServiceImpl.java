package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;

import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public void createReview(ReviewRequestDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Member member = memberRepository.findById(1L) // 하드코딩된 사용자
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        Review review = Review.builder()
                .member(member)
                .store(store)
                .score(request.getScore())
                .title(request.getTitle())
                .body(request.getBody())
                .build();

        reviewRepository.save(review);
    }
}