package com.example.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FinanceRequestDto {

    private BigDecimal amount;

    private LocalDate date;

    private String type;

    private String description;

    private String accountName;

    private String categoryName;


}
