package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreMissionResponseDTO {
    private Long memberMissionId;
    private Long memberId;
    private Long missionId;
    private String status;
}