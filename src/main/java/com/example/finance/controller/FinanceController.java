package com.example.finance.controller;

import com.example.finance.dto.FinanceRequestDto;
import com.example.finance.dto.FinanceResponseDto;
import com.example.finance.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finances")
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService financeService;

    @PostMapping
    public ResponseEntity<FinanceResponseDto> createFinance(
            @RequestBody FinanceRequestDto dto,
            Authentication authentication
    ) {
        String username = authentication.getName();
        return ResponseEntity.ok(financeService.createFinance(dto, username));
    }

    @GetMapping
    public ResponseEntity<List<FinanceResponseDto>> listFinances(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(financeService.listFinance(username));
    }

}
