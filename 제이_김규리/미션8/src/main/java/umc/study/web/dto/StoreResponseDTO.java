package umc.study.web.dto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreResponseDTO {
    private Long id;
    private String name;
    private Long regionId;
}