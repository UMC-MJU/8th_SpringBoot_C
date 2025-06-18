package com.example.mission7.repository;

import com.example.mission7.domain.Review;
import com.example.mission7.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    List<Review> findAllByMemberId(UUID memberId);
}
