package com.ballistic.barco.service;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
/**
 * Created by Nabeel on 1/22/2018.
 */
@Component
public class Encryption {

    private static final String ALGO = "AES";
    private static final byte[] keyValue = new byte[] {'B','a','l','l','i','s','t','i','c',' ', 'B','a','r','c','o'};

    /**
     * Encrypt a string with AES algorithm.
     *
     * @param value is a string
     * @return the encrypted string
     */
    public static String encryPtion(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param value is a string
     * @return the decrypted string
     */
    public static String decryPtion(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(value);
        byte[] decValue = cipher.doFinal(decordedValue);
        return new String(decValue);
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, ALGO);
    }
}
