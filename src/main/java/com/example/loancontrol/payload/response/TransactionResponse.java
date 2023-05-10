package com.example.loancontrol.payload.response;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TransactionResponse {

    private String txHash;

    private String status;

    private BigDecimal gasUsed;

    public TransactionResponse(String txHash, String status, BigDecimal gasUsed) {
        this.txHash = txHash;
        this.status = status;
        this.gasUsed = gasUsed;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(BigDecimal gasUsed) {
        this.gasUsed = gasUsed;
    }
}
