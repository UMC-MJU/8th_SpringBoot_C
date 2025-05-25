package com.example.mission7.controller;

import com.example.mission7.dto.request.ChallengeMissionRequestDto;
import com.example.mission7.service.MemberMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/member-missions")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/challenge")
    public ResponseEntity<UUID> challengeMission(@RequestBody ChallengeMissionRequestDto requestDto) {
        UUID memberMissionId = memberMissionService.challengeMission(requestDto);
        return ResponseEntity.ok(memberMissionId);
    }
}
