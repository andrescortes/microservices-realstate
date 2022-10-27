package com.dev.springbootmicroservice3apigateway.request;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    value = "purchase-service",
    path = "api/purchase",
    //url = "${purchase.service.url}",
    configuration = FeignConfiguration.class
)
public interface PurchaseServiceRequest {

    @PostMapping
    Object savePurchase(@RequestBody final Object requestBody);

    @GetMapping("{userId}")
    List<Object> getAllPurchaseByUserId(@PathVariable final Long userId);
}
