package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.mapping.MissionStatus;

@Getter
public class MyMissionRequestDTO {

    @NotNull(message = "status는 필수입니다.")
    private MissionStatus status;
}