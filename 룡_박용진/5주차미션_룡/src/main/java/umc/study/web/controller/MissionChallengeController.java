package umc.study.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.MissionService.MyMissionCommandService;
import umc.study.validation.annotaition.MissionNotAlreadyChallenged;
import umc.study.web.dto.MyMissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/myMission")
public class MissionChallengeController {

    private final MyMissionCommandService myMissionCommandService;

    @PatchMapping("/{missionId}")
    public ResponseEntity<String> challengeMission(
            @PathVariable @MissionNotAlreadyChallenged Long missionId,
            @RequestBody @Valid MyMissionRequestDTO requestDTO) {
        myMissionCommandService.challengeMission(missionId, requestDTO);
        return ResponseEntity.ok("미션 도전 성공");
    }
}
