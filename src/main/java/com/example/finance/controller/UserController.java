package com.example.finance.controller;

import com.example.finance.dto.UserDto;
import com.example.finance.dto.UserResponseDto;
import com.example.finance.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDto> adicionarUsuario(@RequestBody UserDto dto) {
        UserResponseDto response = service.criarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/teste")
    public ResponseEntity<?> teste(){
        return ResponseEntity.ok("API funcionando!"); // retorna uma mensagem simples
    }


}
