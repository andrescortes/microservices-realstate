package com.dev.springbootmicroservice3apigateway.controller;

import com.dev.springbootmicroservice3apigateway.request.PurchaseServiceRequest;
import com.dev.springbootmicroservice3apigateway.security.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gateway/purchase")
public class PurchaseController {

    private final PurchaseServiceRequest purchaseServiceRequest;

    public PurchaseController(PurchaseServiceRequest purchaseServiceRequest) {
        this.purchaseServiceRequest = purchaseServiceRequest;
    }

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody final Object purchase) {
        return new ResponseEntity<>(purchaseServiceRequest.savePurchase(purchase),
            HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ResponseEntity.ok(
            purchaseServiceRequest.getAllPurchaseByUserId(userPrincipal.getId()));
    }
}
