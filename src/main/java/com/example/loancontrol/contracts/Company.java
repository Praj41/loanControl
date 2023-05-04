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
public class Company extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b0319163317905561028b806100326000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80638f32d59b1161005b5780638f32d59b146100ca578063d2452956146100e9578063dd6021ae14610115578063ffcf2fd51461009757600080fd5b8063250f2122146100825780635e46526e146100975780638da5cb5b146100aa575b600080fd5b6100956100903660046101dd565b610138565b005b6100956100a53660046101dd565b610192565b6000546040516001600160a01b0390911681526020015b60405180910390f35b6000546001600160a01b031633145b60405190151581526020016100c1565b6100d96100f73660046101dd565b6001600160a01b031660009081526001602052604090205460ff1690565b6100d96101233660046101dd565b60016020526000908152604090205460ff1681565b6000546001600160a01b0316331461016b5760405162461bcd60e51b81526004016101629061020d565b60405180910390fd5b6001600160a01b03166000908152600160208190526040909120805460ff19169091179055565b6000546001600160a01b031633146101bc5760405162461bcd60e51b81526004016101629061020d565b6001600160a01b03166000908152600160205260409020805460ff19169055565b6000602082840312156101ef57600080fd5b81356001600160a01b038116811461020657600080fd5b9392505050565b60208082526028908201527f46756e6374696f6e2061636365737369626c65206f6e6c7920627920746865206040820152676f776e657220212160c01b60608201526080019056fea26469706673582212202fb032bb19a1485cb3c89542dd77e39ae9e74ae3cc3d5d4c4c57679f43e9c33e64736f6c634300080f0033";

    public static final String FUNC_VERFY_COMP = "Verfy_Comp";

    public static final String FUNC_DELETE_COMP = "delete_Comp";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_IS_VERIFIED = "is_Verified";

    public static final String FUNC_NEWCOMPANY = "newCompany";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_VERIFIEDCOMPANY = "verifiedCompany";

    @Deprecated
    protected Company(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Company(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Company(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Company(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> Verfy_Comp(String comp_addr) {
        final Function function = new Function(
                FUNC_VERFY_COMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(comp_addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> delete_Comp(String comp_addr) {
        final Function function = new Function(
                FUNC_DELETE_COMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(comp_addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> isOwner() {
        final Function function = new Function(
                FUNC_ISOWNER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> is_Verified(String comp_addr) {
        final Function function = new Function(
                FUNC_IS_VERIFIED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(comp_addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> newCompany(String comp_addr) {
        final Function function = new Function(
                FUNC_NEWCOMPANY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(comp_addr)), 
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

    public RemoteCall<TransactionReceipt> verifiedCompany(String param0) {
        final Function function = new Function(
                FUNC_VERIFIEDCOMPANY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Company> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Company.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Company> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Company.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Company> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Company.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Company> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Company.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static Company load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Company(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Company load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Company(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Company load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Company(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Company load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Company(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
