package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.web.dto.StoreRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ResponseEntity<String> createStore(@RequestBody @Valid StoreRequestDTO requestDTO) {
        storeCommandService.createStore(requestDTO);
        return ResponseEntity.ok("가게 등록 성공");
    }
}
