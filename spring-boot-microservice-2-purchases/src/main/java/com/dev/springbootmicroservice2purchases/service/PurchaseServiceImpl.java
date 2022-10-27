package com.dev.springbootmicroservice2purchases.service;

import com.dev.springbootmicroservice2purchases.model.Purchase;
import com.dev.springbootmicroservice2purchases.repository.PurchaseRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository repository;

    public PurchaseServiceImpl(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {
        purchase.setPurchaseDate(LocalDateTime.now());
        return repository.save(purchase);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return repository.findAll();
    }

    @Override
    public List<Purchase> getAllPurchasesByUser(Long userId) {
        return repository.findAllByUserId(userId);
    }
}
