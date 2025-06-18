package com.example.mission7.controller;

import com.example.mission7.domain.MemberMission;
import com.example.mission7.domain.Mission;
import com.example.mission7.dto.request.MissionRequestDto;
import com.example.mission7.service.MemberMissionService;
import com.example.mission7.service.MissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;
    private final MemberMissionService memberMissionService;

    @PostMapping
    @Operation(summary = "미션 추가 API", description = "가게에 새로운 미션을 추가합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "미션 생성 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
    })    public ResponseEntity<UUID> addMission(@RequestBody MissionRequestDto dto) {
        UUID missionId = missionService.addMission(dto);
        return ResponseEntity.ok(missionId);
    }

    @PostMapping
    @Operation(summary = "미션 추가 API", description = "가게에 새로운 미션을 추가합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "미션 생성 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
    })
    public ResponseEntity<List<Mission>> getMissionsByStore(@PathVariable UUID storeId) {
        List<Mission> missions = missionService.getMissionsByStore(storeId);
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/in-progress/{memberId}")
    @Operation(summary = "회원이 진행 중인 미션 목록 조회 API", description = "회원 ID를 통해 현재 진행 중인 미션들을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "진행 중인 미션 목록 조회 성공"),
            @ApiResponse(responseCode = "404", description = "해당 회원을 찾을 수 없음", content = @Content)
    })
    @Parameter(name = "memberId", description = "회원 UUID", required = true)
    public ResponseEntity<List<MemberMission>> getMyInProgressMissions(@PathVariable UUID memberId) {
        List<MemberMission> missions = memberMissionService.getInProgressMissions(memberId);
        return ResponseEntity.ok(missions);
    }

    @PatchMapping("/complete/{memberMissionId}")
    @Operation(summary = "미션 완료 처리 API", description = "회원이 진행 중인 미션을 완료 상태로 변경합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "미션 완료 처리 성공"),
            @ApiResponse(responseCode = "404", description = "해당 미션을 찾을 수 없음", content = @Content)
    })
    @Parameter(name = "memberMissionId", description = "회원 미션 UUID", required = true)
    public ResponseEntity<Void> completeMission(@PathVariable UUID memberMissionId) {
        memberMissionService.completeMission(memberMissionId);
        return ResponseEntity.noContent().build();
    }
}
