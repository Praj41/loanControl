package com.example.loancontrol.payload.request;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class TransactionRequest {

    @NotBlank
    private Long userId;

    @NotBlank
    private String txnPass;

    @NotBlank
    private String receiverAddress;

    @NotBlank
    private BigDecimal amount;

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTxnPass() {
        return txnPass;
    }

    public void setTxnPass(String txnPass) {
        this.txnPass = txnPass;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
