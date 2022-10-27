package com.dev.springbootmicroservice2purchases.repository;

import com.dev.springbootmicroservice2purchases.model.Purchase;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findAllByUserId(Long userId);
}
