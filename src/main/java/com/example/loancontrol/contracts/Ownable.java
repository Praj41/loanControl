package com.example.loancontrol.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Ownable extends Contract {
    private static final String BINARY = "6080604052348015600f57600080fd5b50600080546001600160a01b0319163317905560aa806100306000396000f3fe6080604052348015600f57600080fd5b506004361060325760003560e01c80638da5cb5b1460375780638f32d59b146057575b600080fd5b6000546040516001600160a01b0390911681526020015b60405180910390f35b6000546001600160a01b031633146040519015158152602001604e56fea264697066735822122033325cb96381804393c06b672585dc54bcfb8fb13da046a80e3657f2533e2b6b64736f6c634300080f0033";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_OWNER = "owner";

    @Deprecated
    protected Ownable(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Ownable(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Ownable(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Ownable(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Ownable> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Ownable.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Ownable> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Ownable.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Ownable> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Ownable.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Ownable> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Ownable.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public RemoteCall<TransactionReceipt> isOwner() {
        final Function function = new Function(
                FUNC_ISOWNER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> owner() {
        final Function function = new Function(
                FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Ownable load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ownable(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Ownable load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ownable(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Ownable load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Ownable(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Ownable load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Ownable(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
