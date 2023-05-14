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
public class LinkAccounts extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506101b4806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806364c26d6b1461005157806394b53e641461007f578063d502dd82146100c4578063e0b9d9bc146100ed575b600080fd5b61007d61005f366004610129565b600090815260208190526040902080546001600160a01b0319169055565b005b6100a861008d366004610129565b6000908152602081905260409020546001600160a01b031690565b6040516001600160a01b03909116815260200160405180910390f35b6100a86100d2366004610129565b6000602081905290815260409020546001600160a01b031681565b61007d6100fb366004610142565b60009182526020829052604090912080546001600160a01b0319166001600160a01b03909216919091179055565b60006020828403121561013b57600080fd5b5035919050565b6000806040838503121561015557600080fd5b8235915060208301356001600160a01b038116811461017357600080fd5b80915050925092905056fea264697066735822122072e88f07c80b56f77ed489b6458b20cc8af66fd47a9d1229da03319755e9236e64736f6c634300080f0033";

    public static final String FUNC_DELETE_ACCOUNT = "delete_account";

    public static final String FUNC_GETDIGITALACCOUNT = "getDigitalAccount";

    public static final String FUNC_LINKACCOUNT = "linkAccount";

    public static final String FUNC_PHYSICALTODIGITALACC = "physicalToDigitalAcc";

    @Deprecated
    protected LinkAccounts(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LinkAccounts(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LinkAccounts(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LinkAccounts(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> delete_account(BigInteger physicalAccount) {
        final Function function = new Function(
                FUNC_DELETE_ACCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(physicalAccount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getDigitalAccount(BigInteger physicalAccount) {
        final Function function = new Function(
                FUNC_GETDIGITALACCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(physicalAccount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> linkAccount(BigInteger physicalAccount, String digitalAccount) {
        final Function function = new Function(
                FUNC_LINKACCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(physicalAccount), 
                new org.web3j.abi.datatypes.Address(digitalAccount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> physicalToDigitalAcc(BigInteger param0) {
        final Function function = new Function(
                FUNC_PHYSICALTODIGITALACC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<LinkAccounts> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LinkAccounts.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LinkAccounts> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LinkAccounts.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<LinkAccounts> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(LinkAccounts.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<LinkAccounts> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(LinkAccounts.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static LinkAccounts load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LinkAccounts(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LinkAccounts load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LinkAccounts(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LinkAccounts load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LinkAccounts(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LinkAccounts load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LinkAccounts(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
