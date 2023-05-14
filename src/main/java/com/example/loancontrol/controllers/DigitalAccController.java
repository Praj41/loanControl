package com.example.loancontrol.controllers;

import com.example.loancontrol.contracts.LinkAccounts;
import com.example.loancontrol.contracts.TransferToken;
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
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Base64;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/DigAcc")
public class DigitalAccController {

    @Autowired
    DigitalAccRepository digitalAccRepository;

    @Autowired
    UserRepository userRepository;
    Web3j client;
    TransactionManager transactionManager;
    LinkAccounts contract;
    public DigitalAccController() throws IOException {
        client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));
        System.out.println("Loading Accounts Contract\n" + client.web3ClientVersion().send().getWeb3ClientVersion());

        transactionManager = new RawTransactionManager(client, Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3"), 80001);
        contract = LinkAccounts.load("0x7EC214483DAc588620A4F55284C4F5385dC0a9e2", client, transactionManager, new DefaultGasProvider());
    }

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

    @PutMapping("/linkaccounts/{accId}/{digAccId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> linkAccounts(@PathVariable BigInteger accId, @PathVariable String digAccId) throws Exception {

        TransactionReceipt tx = contract.linkAccount(accId, digAccId).send();

        System.out.println("Transaction Hash: " + tx.getTransactionHash());
        System.out.println("Status: " + tx.getStatus());
        System.out.println("Total Gas Used: " + new BigDecimal(new BigInteger(tx.getEffectiveGasPrice().substring(2), 16)).multiply(new BigDecimal(tx.getGasUsed())).scaleByPowerOfTen(-18));

        return ResponseEntity.ok("Account linked successfully!");
    }

    @DeleteMapping("/unlinkaccounts/{accId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> unlinkAccounts(@PathVariable BigInteger accId) throws Exception {

        TransactionReceipt tx = contract.delete_account(accId).send();

        System.out.println("Transaction Hash: " + tx.getTransactionHash());
        System.out.println("Status: " + tx.getStatus());
        System.out.println("Total Gas Used: " + new BigDecimal(new BigInteger(tx.getEffectiveGasPrice().substring(2), 16)).multiply(new BigDecimal(tx.getGasUsed())).scaleByPowerOfTen(-18));

        return ResponseEntity.ok("Account unlinked successfully!");
    }
}
