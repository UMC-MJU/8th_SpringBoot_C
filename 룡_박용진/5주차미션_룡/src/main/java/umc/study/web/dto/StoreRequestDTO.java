package umc.study.web.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class StoreRequestDTO {
    @NotBlank
    private String name;

    @NotNull(message = "region_id는 필수입니다.")
    private Long region_id;
}