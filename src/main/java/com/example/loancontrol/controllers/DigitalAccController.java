package com.example.loancontrol.controllers;

import com.example.loancontrol.model.DigitalAccount;
import com.example.loancontrol.model.User;
import com.example.loancontrol.model.ivCipherPair;
import com.example.loancontrol.repository.DigitalAccRepository;
import com.example.loancontrol.repository.UserRepository;
import com.example.loancontrol.security.services.UserDetailsImpl;
import com.example.loancontrol.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/DigAcc")
public class DigitalAccController {

    @Autowired
    DigitalAccRepository digitalAccRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> create(Authentication authentication, @RequestBody DigitalAccount digitalAccount) {

        ivCipherPair pair = EncryptionService.encryptPrivateKey(digitalAccount.getPrivateKey(), digitalAccount.getTxPass());


        digitalAccount.setPrivateKey(Base64.getEncoder().encodeToString(pair.getCipher()));
        digitalAccount.setIV(Base64.getEncoder().encodeToString(pair.getIv()));

        System.out.println(((UserDetailsImpl) authentication.getPrincipal()).getId());

        digitalAccount.setUserId(userRepository.getReferenceById(((UserDetailsImpl) authentication.getPrincipal()).getId()));

        digitalAccRepository.save(digitalAccount);

        return ResponseEntity.ok("Digital Account created successfully!");
    }

    @PostMapping("/getPrivateKey")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getPrivateKey(Authentication authentication, @RequestBody DigitalAccount digitalAccount) {

        DigitalAccount account = digitalAccRepository.findByUser(userRepository.getReferenceById(((UserDetailsImpl) authentication.getPrincipal()).getId()));


        return ResponseEntity.ok(EncryptionService.decryptPrivateKey(new ivCipherPair(Base64.getDecoder().decode(account.getIV()), Base64.getDecoder().decode(account.getPrivateKey())), digitalAccount.getTxPass()));
    }

}
