package com.example.mission7.repository;

import com.example.mission7.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, UUID> {
}