package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMissionResponseDTO {
    private Long missionId;
    private String content;
    private Integer point;
    private String status;
}
