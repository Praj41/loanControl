package com.example.loancontrol.model;

public class ivCipherPair {
    private byte[] iv;
    private byte[] cipher;

    public ivCipherPair(byte[] iv, byte[] cipher) {
        this.iv = iv;
        this.cipher = cipher;
    }

    public byte[] getIv() {
        return iv;
    }

    public byte[] getCipher() {
        return cipher;
    }
}
