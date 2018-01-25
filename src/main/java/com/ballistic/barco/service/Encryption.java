package com.ballistic.barco.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
/**
 * Created by Nabeel on 1/22/2018.
 */
@Component
public class Encryption {

    private final static Logger log = LoggerFactory.getLogger(Encryption.class);

    private static final String ALGO = "AES";
    private static final byte[] keyValue = new byte[] {'B','a','l','l','i','s','t','i','c','0','0', 'B','a','r','c','o'};

    /**
     * Encrypt a string with AES algorithm.
     *
     * @param value is a string
     * @return the encrypted string
     */
    public static String encryPtion(String value) {

        try {

            log.info("Start.....encryPtion");
            Key key = generateKey();
            log.info("Key.....generatedKey......{}", key.toString());
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = cipher.doFinal(value.getBytes());
            log.info("EnCode....process....final");
            return Base64.getEncoder().encodeToString(encVal);

        }catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException |
                BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param value is a string
     * @return the decrypted string
     */
    public static String decryPtion(String value) throws IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

        try {

            log.info("Start.....decryPtion");
            Key key = generateKey();
            log.info("Key.....generatedKey......{}", key.toString());
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = Base64.getDecoder().decode(value);
            byte[] decValue = cipher.doFinal(decordedValue);
            log.info("DeCode....process....final");
            return new String(decValue);

        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException |
                BadPaddingException | IllegalBlockSizeException e) {
           throw e;
        }
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey() {
        log.info("Key Generate with keyValue.....{} and ALGO....{}", keyValue, ALGO);
        return new SecretKeySpec(keyValue, ALGO);
    }
}
