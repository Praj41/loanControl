package com.example.loancontrol.controllers;

import com.example.loancontrol.model.DigitalAccount;
import com.example.loancontrol.model.ivCipherPair;
import com.example.loancontrol.payload.request.TransactionRequest;
import com.example.loancontrol.payload.response.TransactionResponse;
import com.example.loancontrol.repository.DigitalAccRepository;
import com.example.loancontrol.repository.UserRepository;
import com.example.loancontrol.security.services.UserDetailsImpl;
import com.example.loancontrol.service.BlockchainService;
import com.example.loancontrol.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    DigitalAccRepository digitalAccRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlockchainService blockchainService;

    @GetMapping("/getDetails/{txnId}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getDetails(@PathVariable String txnId) {
        try {
            return ResponseEntity.ok(blockchainService.getTransactionDetails(txnId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }

    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getPrivateKey(Authentication authentication, @RequestBody TransactionRequest transactionRequest) {

        DigitalAccount account = digitalAccRepository.findByUser(userRepository.getReferenceById(((UserDetailsImpl) authentication.getPrincipal()).getId()));

        String privateKey = EncryptionService.decryptPrivateKey(new ivCipherPair
                (Base64.getDecoder().decode(account.getIV()), Base64.getDecoder().decode(account.getPrivateKey())), transactionRequest.getTxnPass());

        TransactionResponse response = null;
        try {
            response = blockchainService.transfer(privateKey, transactionRequest.getReceiverAddress(), transactionRequest.getAmount());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }

    }

}
