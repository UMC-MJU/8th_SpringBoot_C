package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.StoreService.StoreService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreResponseDTO> addStore(@Valid @RequestBody StoreRequestDTO request) {
        return ResponseEntity.ok(storeService.addStore(request));
    }
}