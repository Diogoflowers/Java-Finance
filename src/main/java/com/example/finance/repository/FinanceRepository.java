package com.example.finance.repository;

import com.example.finance.model.Finance;
import com.example.finance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
    List<Finance> findByUser(User user);
}
