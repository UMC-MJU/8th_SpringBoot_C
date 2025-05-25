package umc.study.web.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ValidStore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ValidStore
public class ReviewRequestDTO {
    @NotNull(message = "회원 ID는 필수입니다.")
    private Long memberId;

    @NotNull(message = "가게 ID는 필수입니다.")
    private Long storeId;

    private String title;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private Float score;
}
