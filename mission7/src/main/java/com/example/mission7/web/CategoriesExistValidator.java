package com.example.mission7.web;

import com.example.mission7.exception.error.ErrorStatus;
import com.example.mission7.service.FoodCategoryService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<UUID>> {

    private final FoodCategoryService foodCategoryService;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<UUID> values, ConstraintValidatorContext context) {
        boolean isValid = foodCategoryService.validateExistAll(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
