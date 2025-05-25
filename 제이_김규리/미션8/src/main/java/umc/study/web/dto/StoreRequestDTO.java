package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class StoreRequestDTO {

    @NotBlank(message = "가게 이름은 필수입니다.")
    private String name;

    @NotNull(message = "지역 ID는 필수입니다.")
    private Long regionId;
}