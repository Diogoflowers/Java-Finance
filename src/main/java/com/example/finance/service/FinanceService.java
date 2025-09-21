package com.example.finance.service;

import com.example.finance.dto.FinanceRequestDto;
import com.example.finance.dto.FinanceResponseDto;
import com.example.finance.mapper.FinanceMapper;
import com.example.finance.model.Finance;
import com.example.finance.model.User;
import com.example.finance.repository.FinanceRepository;
import com.example.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FinanceService {

    private final FinanceRepository repository;
    private final UserRepository userRepository;

    public FinanceResponseDto createFinance(FinanceRequestDto dto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Finance finance = FinanceMapper.toEntity(dto, user);
        Finance saved = repository.save(finance);
        return FinanceMapper.toDto(saved);
    }

    public List<FinanceResponseDto> listFinance(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return repository.findByUser(user).stream()
                .map(FinanceMapper::toDto)
                .toList();
    }

    public void deleteFinance(Long id, String username) throws AccessDeniedException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Finance finance = repository.findByIdAndUser(id, user)
                .orElseThrow(() -> new AccessDeniedException("Recurso não encontrado ou não pertence ao usuário"));

        repository.delete(finance);
    }
}
