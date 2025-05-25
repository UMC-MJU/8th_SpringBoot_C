package com.example.mission7.controller;

import com.example.mission7.dto.request.MissionRequestDto;
import com.example.mission7.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<UUID> addMission(@RequestBody MissionRequestDto dto) {
        UUID missionId = missionService.addMission(dto);
        return ResponseEntity.ok(missionId);
    }
}
