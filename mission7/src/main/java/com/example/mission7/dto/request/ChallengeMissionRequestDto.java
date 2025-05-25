package com.example.mission7.dto.request;

import com.example.mission7.web.NotChallengedMission;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ChallengeMissionRequestDto {
    @NotNull(message = "missionId는 필수입니다.")
    @NotChallengedMission
    private UUID missionId;}

