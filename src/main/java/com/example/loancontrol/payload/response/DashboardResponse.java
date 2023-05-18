package com.example.loancontrol.payload.response;

import com.example.loancontrol.model.User;

import java.math.BigDecimal;

public class DashboardResponse {
    String username;

    String email;

    BigDecimal balance;

    String publicKey;

    public DashboardResponse(User user, BigDecimal balance) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.balance = balance;
        this.publicKey = user.getDigitalAccount().getPublicKey();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
