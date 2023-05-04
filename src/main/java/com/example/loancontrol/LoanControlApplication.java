package com.example.loancontrol;

import com.example.loancontrol.contracts.TransferToken;
import com.example.loancontrol.service.encryptionService;
import model.ivCipherPair;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

@SpringBootApplication
public class LoanControlApplication {


    public static void main(String[] args) throws Exception {
        //SpringApplication.run(LoanControlApplication.class, args);

        //Transfer token to another account

        //transfer();
/*
        Web3j client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));
        System.out.println(client.web3ClientVersion().send().getWeb3ClientVersion());

        TransactionManager transactionManager = new RawTransactionManager(client, Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3"), 80001);
        TransferToken contract = TransferToken.load("0x90010037942f8d8d9c865d059ef76172d8c64a12", client, transactionManager, new DefaultGasProvider());

        //System.out.println("Contract Owner: " + contract.owner().toString());

        //checkCompany("0x287037db7245954a89E630c8429E503ef24C2f54", contract);

        //validateCompany("0x287037db7245954a89E630c8429E503ef24C2f54", contract);

        //checkCompany("0x287037db7245954a89E630c8429E503ef24C2f54", contract);

        System.out.println("Balance Before :" + client.ethGetBalance("0x2f71CA3d31Cb091B8A67F28F229700F307B6ed9e", DefaultBlockParameterName.LATEST).send().getBalance());

        transfer();

        System.out.println("Balance After :" + client.ethGetBalance("0x2f71CA3d31Cb091B8A67F28F229700F307B6ed9e", DefaultBlockParameterName.LATEST).send().getBalance());
*/

        ivCipherPair secret = encryptionService.encryptPrivateKey("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3", "password");

        encryptionService.decryptPrivateKey(secret, "password");

    }

}
