package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.MemberMissionService.MemberMissionService;
import umc.study.web.dto.StoreMissionRequestDTO;
import umc.study.web.dto.StoreMissionResponseDTO;

@RestController
@RequestMapping("/api/member-missions")
@RequiredArgsConstructor
public class MemberMissionRestController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/challenge")
    public ResponseEntity<StoreMissionResponseDTO> challengeMission(@Valid @RequestBody StoreMissionRequestDTO request) {
        return ResponseEntity.ok(memberMissionService.challengeMission(request));
    }
}