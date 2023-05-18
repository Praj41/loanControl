package com.example.loancontrol.service;

import com.example.loancontrol.contracts.TransferToken;
import com.example.loancontrol.payload.response.TransactionResponse;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Bool;
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
import java.math.BigInteger;

@Service
public class BlockchainService {
/*
    public void transfer() throws IOException {
        Web3j client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));
        System.out.println(client.web3ClientVersion().send().getWeb3ClientVersion());

        System.out.println("Sender Balance" + client.ethGetBalance("0xbd0b736BbacC2C206324c83618566f8965111ED2", DefaultBlockParameterName.LATEST).send().getBalance());

        Credentials fromCredentials = Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3");

        //Credentials toCredentials = Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3");

        String toAddress = "0x2f71CA3d31Cb091B8A67F28F229700F307B6ed9e";

        System.out.println("Sending 0.010860502316750395 ");

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
*/


    public void deploy() throws IOException {
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

    public void addCompany(String address, TransferToken contract) {

        try {


            TransactionReceipt tx = contract.newCompany(address).send();

            System.out.println("Transaction hash: " + tx.getTransactionHash());
            System.out.println("Transaction status: " + tx.getStatus());
            System.out.println("Transaction gas used: " + tx.getGasUsed());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void validateCompany(String address, TransferToken contract) {

        try {
            TransactionReceipt tx = contract.Verfy_Comp(address).send();

            System.out.println("Transaction hash: " + tx.getTransactionHash());
            System.out.println("Transaction status: " + tx.getStatus());
            System.out.println("Transaction gas used: " + new BigDecimal(new BigInteger(tx.getEffectiveGasPrice().substring(2), 16)).multiply(new BigDecimal(tx.getGasUsed())).scaleByPowerOfTen(-18));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean checkCompany(String address, TransferToken contract) {

        Boolean isVerified = false;

        try {
            isVerified = contract.is_Verified(address);
            System.out.println("The company is verified: " + isVerified);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isVerified;
    }

    public TransactionResponse transfer(String privateKey, String receiverAddress, BigDecimal amount) throws IOException {
        Web3j client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));

        System.out.println(client.web3ClientVersion().send().getWeb3ClientVersion());

        Credentials fromCredentials = Credentials.create(privateKey);

        //Credentials toCredentials = Credentials.create("2fd0793c7604e3642be5034552d563a9eb9841b9eccfba2a6b1a40b33ce1bff3");

        System.out.println("Sending : " + amount);

        amount = amount.multiply(new BigDecimal("1000000000000000000"));

        try {

            TransactionManager transactionManager = new RawTransactionManager(client, fromCredentials, 80001);

            TransactionReceipt receipt = new Transfer(client, transactionManager).sendFunds(receiverAddress, amount, Convert.Unit.WEI).send();

            BigDecimal fee = new BigDecimal(new BigInteger(receipt.getEffectiveGasPrice().substring(2), 16)).multiply(new BigDecimal(receipt.getGasUsed())).scaleByPowerOfTen(-18);

            System.out.println("Transaction hash: " + receipt.getTransactionHash());
            System.out.println("Transaction status: " + receipt.getStatus());
            System.out.println("Transaction gas used: " + fee);
            System.out.println("Total Transaction cost: " + fee.add(amount.divide(new BigDecimal("1000000000000000000"))));

            return new TransactionResponse(receipt.getTransactionHash(), receipt.getStatus(), fee);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            return new TransactionResponse("Error", e.getMessage(), BigDecimal.valueOf(0));
        }

    }

    public BigDecimal getBalance(String address) throws IOException {
        Web3j client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));

        return new BigDecimal(client.ethGetBalance(address, DefaultBlockParameterName.LATEST).send().getBalance());
    }

    public TransactionReceipt getTransactionDetails(String txnId) throws IOException {
        Web3j client = Web3j.build(new HttpService("https://matic-mumbai.chainstacklabs.com"));

        return client.ethGetTransactionReceipt(txnId).send().getTransactionReceipt().get();
    }
}
