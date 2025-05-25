package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.UniqueChallengeMission;

@Getter
@UniqueChallengeMission
public class StoreMissionRequestDTO {
    @NotNull(message = "회원 ID는 필수입니다.")
    private Long memberId;

    @NotNull(message = "미션 ID는 필수입니다.")
    private Long missionId;
}