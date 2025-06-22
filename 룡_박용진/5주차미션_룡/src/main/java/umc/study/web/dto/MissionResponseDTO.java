package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionResponseDTO {
    private Long missionId;
    private String content;
    private Integer point;
}
