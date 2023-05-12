package com.example.loancontrol.controllers;

import com.example.loancontrol.contracts.TransferToken;
import com.example.loancontrol.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/company")
public class AdminController {


    @Autowired
    BlockchainService blockchainService;

    Web3j client;

    TransactionManager transactionManager;
    TransferToken contract;
    public AdminController() throws IOException {
        client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));
        System.out.println(client.web3ClientVersion().send().getWeb3ClientVersion());

        transactionManager = new RawTransactionManager(client, Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3"), 80001);
        contract = TransferToken.load("0x90010037942f8d8d9c865d059ef76172d8c64a12", client, transactionManager, new DefaultGasProvider());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create/{address}")
    public String createCompany(@PathVariable String address) {

        blockchainService.addCompany(address, contract);

        return "Company created successfully!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/check/{address}")
    public String checkCompany(@PathVariable String address) {

        blockchainService.addCompany(address, contract);

        return "Company created successfully!";
    }



}
