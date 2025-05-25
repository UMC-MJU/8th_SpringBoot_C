package umc.study.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MissionRequestDTO {

    @NotBlank
    private String missionSpec;  // 설명

    @NotNull
    private LocalDate deadline;  // 마감일

    @NotNull
    @Min(0)
    private Integer reward;      // 포인트
}
