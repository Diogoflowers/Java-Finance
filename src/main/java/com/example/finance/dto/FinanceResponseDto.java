package com.example.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class FinanceResponseDto {
    private Long id;
    private BigDecimal amount;
    private LocalDate date;
    private String type;
    private String description;
    private String accountName;
    private String categoryName;
    private String username;
}
