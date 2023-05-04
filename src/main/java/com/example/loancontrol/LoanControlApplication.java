package com.example.loancontrol;

import com.example.loancontrol.service.encryptionService;
import com.example.loancontrol.model.ivCipherPair;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
