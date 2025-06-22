package umc.study.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class ReviewRequestDTO {

    @NotNull(message = "store_id는 필수입니다.")
    private Long storeId;

    @Min(1)
    @Max(5)
    private float score;

    @NotBlank
    private String title;

    @NotBlank
    private String body;
}
