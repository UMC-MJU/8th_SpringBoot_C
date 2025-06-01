package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    Optional<Store> findStore(Long id);

    List<Store> findStoresByNameAndScore(String name, Float score);

    Page<Review> getReviewList(Long StoreId, Integer page);
}