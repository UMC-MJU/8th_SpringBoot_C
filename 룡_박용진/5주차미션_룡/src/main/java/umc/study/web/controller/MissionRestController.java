package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}/mission")
    public ResponseEntity<String> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequestDTO requestDTO) {
        missionCommandService.createMission(storeId, requestDTO);
        return ResponseEntity.ok("미션 등록 성공");
    }
}
