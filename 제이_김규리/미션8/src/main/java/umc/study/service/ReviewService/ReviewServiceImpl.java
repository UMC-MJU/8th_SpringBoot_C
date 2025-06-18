package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MemberRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponseDTO addReview(ReviewRequestDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new NoSuchElementException("Store not found"));
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new NoSuchElementException("Member not found"));

        Review review = Review.builder()
                .store(store)
                .member(member)
                .title(request.getTitle())
                .score(request.getScore())
                .build();

        Review savedReview = reviewRepository.save(review);

        return ReviewResponseDTO.builder()
                .id(savedReview.getId())
                .title(savedReview.getTitle())
                .score(savedReview.getScore())
                .memberId(savedReview.getMember().getId())
                .storeId(savedReview.getStore().getId())
                .build();


    }
    @Override
    public Page<ReviewResponseDTO> getMyReviews(Long memberId, int page) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("Member not found"));

        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<Review> reviews = reviewRepository.findAllByMemberId(memberId, pageRequest);

        return reviews.map(review -> ReviewResponseDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .build());
    }
}
