import org.bson.assertions.Assertions;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

public class Security {

    static String Algorithm = "AES/CBC/PKCS5Padding";
    //static SecretKey Key = Security.generateKey(128);


    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        SecretKey key = null;
        try
        {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(n);
            key = keyGenerator.generateKey();

        }catch (Exception ex)
        {
            throw ex;
        }
        finally {
            return key;
        }

    }
    public String Encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(Algorithm);
        SecretKey Key = Security.generateKey(128);
        int[] keys = new int[]{27, -94, -69, -65, -23, 16, -3, -69, -66, -44, -22, -32, -87, -111, 68, -193};
        System.out.println(Key);
        IvParameterSpec IV = Security.generateIv();
        cipher.init(Cipher.ENCRYPT_MODE,Key ,IV);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    public String Decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.DECRYPT_MODE, Security.generateKey(128), Security.generateIv());
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);
    }
    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public void givenString_whenEncrypt_thenSuccess()
            throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {

        String input = "S3lo@ne#123";
//        SecretKey key = Security.generateKey(128);
//        IvParameterSpec ivParameterSpec = Security.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        //String cipherText = Security.encrypt(algorithm, input, Security.generateKey(128), Security.generateIv());
        //String plainText = Security.decrypt(algorithm, cipherText, Security.generateKey(128), Security.generateIv());
        //assertEquals(input, plainText);
    }

}
