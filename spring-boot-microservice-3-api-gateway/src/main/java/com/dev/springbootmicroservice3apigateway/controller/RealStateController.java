package com.dev.springbootmicroservice3apigateway.controller;

import com.dev.springbootmicroservice3apigateway.request.RealStateServiceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gateway/real-state")
public class RealStateController {

    private final RealStateServiceRequest realStateServiceRequest;

    public RealStateController(RealStateServiceRequest realStateServiceRequest) {
        this.realStateServiceRequest = realStateServiceRequest;
    }

    @PostMapping
    public ResponseEntity<?> saveRealState(@RequestBody final Object realState) {
        return new ResponseEntity<>(realStateServiceRequest.saveRealState(realState),
            HttpStatus.CREATED);
    }

    @DeleteMapping("{realStateId}")
    public ResponseEntity<?> deleteRealState(@PathVariable final Long realStateId) {
        realStateServiceRequest.deleteRealState(realStateId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllRealState(){
        return ResponseEntity.ok(realStateServiceRequest.getAllRealState());
    }
}
