package com.example.loancontrol.contracts;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class TransferToken extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b031916331790556103db806100326000396000f3fe6080604052600436106100915760003560e01c80638f32d59b116100595780638f32d59b14610120578063d24529561461014c578063dd6021ae14610185578063e9bb84c2146101b5578063ffcf2fd5146100d857600080fd5b8063250f21221461009657806325caa262146100b85780634185f8eb146100b65780635e46526e146100d85780638da5cb5b146100f8575b600080fd5b3480156100a257600080fd5b506100b66100b136600461030d565b6101d5565b005b3480156100c457600080fd5b506040514781526020015b60405180910390f35b3480156100e457600080fd5b506100b66100f336600461030d565b61022f565b34801561010457600080fd5b506000546040516001600160a01b0390911681526020016100cf565b34801561012c57600080fd5b506000546001600160a01b031633145b60405190151581526020016100cf565b34801561015857600080fd5b5061013c61016736600461030d565b6001600160a01b031660009081526001602052604090205460ff1690565b34801561019157600080fd5b5061013c6101a036600461030d565b60016020526000908152604090205460ff1681565b3480156101c157600080fd5b506100b66101d0366004610331565b61027a565b6000546001600160a01b031633146102085760405162461bcd60e51b81526004016101ff9061035d565b60405180910390fd5b6001600160a01b03166000908152600160208190526040909120805460ff19169091179055565b6000546001600160a01b031633146102595760405162461bcd60e51b81526004016101ff9061035d565b6001600160a01b03166000908152600160205260409020805460ff19169055565b8161029d816001600160a01b031660009081526001602052604090205460ff1690565b6102b95760405162461bcd60e51b81526004016101ff9061035d565b6040516001600160a01b0384169083156108fc029084906000818181858888f193505050501580156102ef573d6000803e3d6000fd5b50505050565b6001600160a01b038116811461030a57600080fd5b50565b60006020828403121561031f57600080fd5b813561032a816102f5565b9392505050565b6000806040838503121561034457600080fd5b823561034f816102f5565b946020939093013593505050565b60208082526028908201527f46756e6374696f6e2061636365737369626c65206f6e6c7920627920746865206040820152676f776e657220212160c01b60608201526080019056fea2646970667358221220f8dcfbc6b58bf02d732528dacc15536bfe06a736236674eba48f9a3f9624643064736f6c634300080f0033";

    public static final String FUNC_VERFY_COMP = "Verfy_Comp";

    public static final String FUNC_DELETE_COMP = "delete_Comp";

    public static final String FUNC_GETBAL = "getBal";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_IS_VERIFIED = "is_Verified";

    public static final String FUNC_NEWCOMPANY = "newCompany";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RECEIVEETH = "receiveEth";

    public static final String FUNC_TRANSFERETH = "transferEth";

    public static final String FUNC_VERIFIEDCOMPANY = "verifiedCompany";

    @Deprecated
    protected TransferToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransferToken(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TransferToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TransferToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<TransactionReceipt> getBal() {
        final Function function = new Function(
                FUNC_GETBAL, 
                Arrays.<Type>asList(), 
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

    public Boolean is_Verified(String comp_addr) throws IOException {
        final Function function = new Function(
                FUNC_IS_VERIFIED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(comp_addr)),
                Arrays.asList(new TypeReference<Bool>(){}));
        return executeCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> newCompany(String comp_addr) {
        final Function function = new Function(
                FUNC_NEWCOMPANY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(comp_addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public Address owner() throws IOException {
        final Function function = new Function(
                FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.asList(new TypeReference<org.web3j.abi.datatypes.Address>(){}));
        return executeCallSingleValueReturn(function, Address.class);
    }

    public RemoteCall<TransactionReceipt> receiveEth() {
        final Function function = new Function(
                FUNC_RECEIVEETH, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferEth(String add, BigInteger amt) {
        final Function function = new Function(
                FUNC_TRANSFERETH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(add), 
                new org.web3j.abi.datatypes.generated.Uint256(amt)), 
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

    public static RemoteCall<TransferToken> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TransferToken.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TransferToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransferToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TransferToken> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TransferToken.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TransferToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TransferToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static TransferToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TransferToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TransferToken load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TransferToken(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TransferToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TransferToken(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
