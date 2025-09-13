package com.example.finance.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserResponseDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String username;
}
