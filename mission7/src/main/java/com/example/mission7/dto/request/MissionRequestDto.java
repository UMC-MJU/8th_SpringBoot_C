package com.example.mission7.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class MissionRequestDto {
    private UUID storeId;
    private int reward;
    private LocalDateTime deadline;
    private String missionSpec;
}
