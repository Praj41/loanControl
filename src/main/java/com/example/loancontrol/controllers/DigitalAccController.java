package com.example.loancontrol.controllers;

import com.example.loancontrol.model.DigitalAccount;
import com.example.loancontrol.repository.DigitalAccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/DigAcc")
public class DigitalAccController {

    @Autowired
    DigitalAccRepository digitalAccRepository;

    @PostMapping ("/create")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> create(@RequestBody DigitalAccount digitalAccount) {

        digitalAccRepository.save(digitalAccount);

        return ResponseEntity.ok("Digital Account created successfully!");
    }
}
