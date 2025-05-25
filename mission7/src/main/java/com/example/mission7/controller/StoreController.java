package com.example.mission7.controller;

import com.example.mission7.dto.request.StoreRequestDto;
import com.example.mission7.service.StoreService.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<UUID> addStore(@RequestBody StoreRequestDto dto) {
        UUID storeId = storeService.addStore(dto);
        return ResponseEntity.ok(storeId);
    }
}

