package com.example.finance.service;

import com.example.finance.dto.UserDto;
import com.example.finance.dto.UserResponseDto;
import com.example.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;



    public UserResponseDto criarUsuario(UserDto dto) {
        return null;
    }
}
