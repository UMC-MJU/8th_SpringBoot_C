package com.example.mission7.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ReviewRequestDto {

    @NotNull(message = "storeId는 필수입니다.")
    private UUID storeId;

    @NotBlank(message = "리뷰 내용은 필수입니다.")
    private String content;

    @NotNull(message = "점수는 필수입니다.")
    @Min(value = 1, message = "점수는 1 이상이어야 합니다.")
    @Max(value = 5, message = "점수는 5 이하이어야 합니다.")
    private Integer rating;
}
