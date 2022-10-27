package com.dev.springbootmicroservice2purchases.service;

import com.dev.springbootmicroservice2purchases.model.Purchase;
import java.util.List;

public interface PurchaseService{

    Purchase savePurchase(Purchase purchase);

    List<Purchase> getAllPurchases();

    List<Purchase> getAllPurchasesByUser(Long userId);
}
