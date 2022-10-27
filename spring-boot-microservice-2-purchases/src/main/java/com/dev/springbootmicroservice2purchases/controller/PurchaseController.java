package com.dev.springbootmicroservice2purchases.controller;

import com.dev.springbootmicroservice2purchases.model.Purchase;
import com.dev.springbootmicroservice2purchases.service.PurchaseService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> savePurchase(@RequestBody final Purchase purchase) {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return new ResponseEntity<>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<List<Purchase>> getAllPurchasesByUserId(@PathVariable final Long userId) {
        return new ResponseEntity<>(purchaseService.getAllPurchasesByUser(userId), HttpStatus.OK);
    }

}
