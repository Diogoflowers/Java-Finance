package com.example.finance.service;

import com.example.finance.dto.UserDto;
import com.example.finance.dto.UserResponseDto;
import com.example.finance.mapper.UserMapper;
import com.example.finance.model.User;
import com.example.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto criarUsuario(UserDto dto) {
        if (repository.findByUsername(dto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Usuário já existe!");
        }
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        User user = UserMapper.toEntity(dto, encodedPassword);
        User saved = repository.save(user);
        return UserMapper.toDto(saved);
    }
}
