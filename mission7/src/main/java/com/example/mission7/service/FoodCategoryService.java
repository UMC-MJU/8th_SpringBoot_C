package com.example.mission7.service;

import com.example.mission7.repository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean validateExistAll(List<UUID> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}
