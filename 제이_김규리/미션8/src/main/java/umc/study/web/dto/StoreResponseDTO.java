package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
    @Getter
    @Builder
    public static class MissionPreviewDTO {
        private Long id;
        private String missionSpec;
        private Integer reward;
        private LocalDate deadline;
    }
    @Getter
    @Builder
    public static class MissionPreviewListDTO {
        private Boolean isLast;
        private Boolean isFirst;
        private Integer totalPage;
        private Long totalElements;
        private Integer listSize;
        private List<MissionPreviewDTO> missionList;
    }

}