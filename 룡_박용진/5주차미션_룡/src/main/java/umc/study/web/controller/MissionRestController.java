package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.validation.annotaition.MissionNotAlreadyChallenged;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/{storeId}/mission")
    public ResponseEntity<String> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequestDTO requestDTO) {
        missionCommandService.createMission(storeId, requestDTO);
        return ResponseEntity.ok("미션 등록 성공");
    }

    @Operation(summary = "가게의 미션 목록 조회")
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<MissionResponseDTO>> getStoreMissions(
            @Parameter(description = "가게 ID") @PathVariable Long storeId,
            @Parameter(description = "페이지 번호") @RequestParam(defaultValue = "0") int page) {

        List<MissionResponseDTO> response = missionQueryService.getMissionsByStoreId(storeId, page);
        return ResponseEntity.ok(response);
    }
}
