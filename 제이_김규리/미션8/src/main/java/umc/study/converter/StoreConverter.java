package umc.study.converter;


import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.domain.Mission;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
    public static StoreResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission) {
        return StoreResponseDTO.MissionPreviewDTO.builder()
                .id(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static StoreResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missions) {
        List<StoreResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missions.stream()
                .map(StoreConverter::missionPreviewDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missions.isLast())
                .isFirst(missions.isFirst())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }

}