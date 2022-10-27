package com.dev.springbootmicroservice1realstate.controller;

import com.dev.springbootmicroservice1realstate.model.RealState;
import com.dev.springbootmicroservice1realstate.service.RealStateService;
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
@RequestMapping("api/real-state")
public class RealStateController {

    private final RealStateService service;

    public RealStateController(RealStateService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveRealState(@RequestBody final RealState realState) {
        return new ResponseEntity<>(service.saveRealState(realState), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRealState(@PathVariable final Long id) {
        service.deleteRealState(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllRealStates() {
        return ResponseEntity.ok(service.findAllRealStates());
    }
}
