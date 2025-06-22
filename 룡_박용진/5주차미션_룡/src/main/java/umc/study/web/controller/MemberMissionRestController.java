package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.web.dto.MemberMissionResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionRestController {

    private final MemberMissionQueryService memberMissionQueryService;
    private final MemberMissionCommandService memberMissionCommandService;

    @Operation(summary = "내가 진행 중인 미션 목록 조회")
    @GetMapping("/my/{memberId}")
    public ResponseEntity<List<MemberMissionResponseDTO>> getMyMissions(
            @Parameter(description = "회원 ID") @PathVariable Long memberId,
            @Parameter(description = "페이지 번호") @RequestParam(defaultValue = "0") int page) {

        List<MemberMissionResponseDTO> response = memberMissionQueryService.getMyInProgressMissions(memberId, page);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "진행 중인 미션 완료로 상태 변경")
    @PostMapping("/{memberId}/{missionId}/complete")
    public ResponseEntity<String> completeMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId) {

        memberMissionCommandService.completeMission(memberId, missionId);
        return ResponseEntity.ok("미션 완료 처리되었습니다.");
    }
}
