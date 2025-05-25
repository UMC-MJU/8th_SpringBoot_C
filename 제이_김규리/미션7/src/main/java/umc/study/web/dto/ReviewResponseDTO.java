package umc.study.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewResponseDTO {
    private Long id;
    private String title;
    private Float score;
    private Long memberId;
    private Long storeId;
}
