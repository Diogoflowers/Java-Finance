package com.example.finance.mapper;

import com.example.finance.dto.FinanceRequestDto;
import com.example.finance.dto.FinanceResponseDto;
import com.example.finance.model.Finance;
import com.example.finance.model.User;

public class FinanceMapper {

    public static FinanceResponseDto toDto(Finance finance) {
        return new FinanceResponseDto(
                finance.getId(),
                finance.getAmount(),
                finance.getDate(),
                finance.getType(),
                finance.getDescription(),
                finance.getAccountName(),
                finance.getCategoryName(),
                finance.getUser().getUsername()
        );
    }

    public static Finance toEntity(FinanceRequestDto dto, User user) {
        return Finance.builder()
                .amount(dto.getAmount())
                .date(dto.getDate())
                .type(dto.getType())
                .description(dto.getDescription())
                .accountName(dto.getAccountName())
                .categoryName(dto.getCategoryName())
                .user(user)
                .build();
    }

}
