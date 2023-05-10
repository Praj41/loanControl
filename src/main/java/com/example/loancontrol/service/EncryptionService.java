package com.example.loancontrol.service;

import com.example.loancontrol.model.DigitalAccount;
import com.example.loancontrol.model.ivCipherPair;
import com.example.loancontrol.repository.DigitalAccRepository;
import com.example.loancontrol.repository.UserRepository;
import com.example.loancontrol.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EncryptionService {

    private static final SecureRandom random = new SecureRandom();

    //Initialise a salt
    static byte[] salt = new byte[16];

    private static SecretKey keyGen(String password) throws Exception {
        salt = "1234567890123456".getBytes();

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }

    private static ivCipherPair encrypt(String privateKey, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[cipher.getBlockSize()]; // generate a random IV
        random.nextBytes(iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));

        return new ivCipherPair(iv, cipher.doFinal(privateKey.getBytes()));

    }

    private static String decrypt(ivCipherPair secret, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        System.out.println("IV: " + secret.getIv().length);

        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(secret.getIv()));

        return new String(cipher.doFinal(secret.getCipher()));
    }

    public static ivCipherPair encryptPrivateKey(String privateKey, String password) {


        try {

            SecretKey key = keyGen(password);
            System.out.println("Key: " + key);
            ivCipherPair secret = encrypt(privateKey, key);
            System.out.println("Length: " + secret.getCipher().length);
            String enc = Base64.getEncoder().encodeToString(secret.getCipher());
            System.out.println("Encrypted: " + enc);
            System.out.println("Decrypted: " + decrypt(new ivCipherPair(secret.getIv(), Base64.getDecoder().decode(enc)), key));

            return secret;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public static String decryptPrivateKey(ivCipherPair secret, String password) {


        try {

            SecretKey key = keyGen(password);
            System.out.println("Key: " + key);
            String dec = decrypt(secret, key);

            System.out.println("Decrypted: " + dec);

            return dec;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "";
    }


}
