package com.example.loancontrol.service;

import com.example.loancontrol.contracts.TransferToken;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;

public class BlockchainService {

    static void transfer() throws IOException {
        Web3j client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));
        System.out.println(client.web3ClientVersion().send().getWeb3ClientVersion());

        System.out.println("Sender Balance" + client.ethGetBalance("0xbd0b736BbacC2C206324c83618566f8965111ED2", DefaultBlockParameterName.LATEST).send().getBalance());

        Credentials fromCredentials = Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3");

        //Credentials toCredentials = Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3");

        String toAddress = "0x2f71CA3d31Cb091B8A67F28F229700F307B6ed9e";

        System.out.println("Sending 0.10860502316750395 ");

        BigDecimal amountInEther = new BigDecimal("10860502316750395");

        try {

            TransactionManager transactionManager = new RawTransactionManager(client, fromCredentials, 80001);

            TransactionReceipt receipt = new Transfer(client, transactionManager).sendFunds(toAddress, amountInEther, Convert.Unit.WEI).send();

            System.out.println("Transaction hash: " + receipt.getTransactionHash());
            System.out.println("Transaction status: " + receipt.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }


    }



    static void deploy() throws IOException {
        Web3j client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));
        System.out.println(client.web3ClientVersion().send().getWeb3ClientVersion());

        //Deploy contract

        Credentials credentials = Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3");

        try {
            TransactionManager transactionManager = new RawTransactionManager(client, credentials, 80001);
            TransferToken contract = TransferToken.deploy(client, transactionManager, new DefaultGasProvider()).send();

            System.out.println("Contract address: " + contract.getContractAddress());
            System.out.println("Transaction hash: " + contract.getTransactionReceipt().get().getTransactionHash());
            System.out.println("Transaction status: " + contract.getTransactionReceipt().get().getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addCompany(String address, TransferToken contract) {

        try {


            TransactionReceipt tx = contract.newCompany(address).send();

            System.out.println("Transaction hash: " + tx.getTransactionHash());
            System.out.println("Transaction status: " + tx.getStatus());
            System.out.println("Transaction gas used: " + tx.getGasUsed());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void validateCompany(String address, TransferToken contract) {

        try {
            TransactionReceipt tx = contract.Verfy_Comp(address).send();

            System.out.println("Transaction hash: " + tx.getTransactionHash());
            System.out.println("Transaction status: " + tx.getStatus());
            System.out.println("Transaction gas used: " + tx.getGasUsed());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void checkCompany(String address, TransferToken contract) {

        try {
            System.out.println("The company is verified: " + contract.is_Verified(address));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
