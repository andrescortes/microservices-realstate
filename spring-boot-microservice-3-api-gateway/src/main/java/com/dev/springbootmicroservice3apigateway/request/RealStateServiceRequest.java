package com.dev.springbootmicroservice3apigateway.request;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//TODO: docker internal network to request ms
@FeignClient(
    value = "real-state-service",//name service application defined in application.yml of msvc-realState
    path = "/api/real-state",
    //url = "${real-state.service.url}", //if eureka-server no yet implemented use url, else omit this line code
    configuration = FeignConfiguration.class
)
public interface RealStateServiceRequest {

    @PostMapping
    Object saveRealState(@RequestBody final Object requestBody);

    @DeleteMapping("{realStateId}")
    void deleteRealState(@PathVariable("realStateId") final Long realStateId);

    @GetMapping
    List<Object> getAllRealState();
}
