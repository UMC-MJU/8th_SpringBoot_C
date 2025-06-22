// ReviewResponseDTO.java

package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ReviewResponseDTO {
    private Long reviewId;
    private String title;
    private String body;
    private Float score;
    private Long memberId;
    private Long storeId;
}
