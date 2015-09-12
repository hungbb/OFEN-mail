/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailclient;


import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author ThanhHung
 */
public class EncryptorDecryptor {
   
   private static final String ALGORITHM       = "AES";
  // private static final String myEncryptionKey = "ThisIsFoundation";
   private static final String UNICODE_FORMAT  = "UTF8";
   
  
   
   

   public static String encrypt(String valueToEnc, String desKey) throws Exception {
        Key key = generateKey(desKey);
        
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);  
        byte[] encValue = c.doFinal(valueToEnc.getBytes(UNICODE_FORMAT));
        String encryptedValue = new BASE64Encoder().encode(encValue);
        return encryptedValue;
   }

    public static String decrypt(String encryptedValue,String desKey) throws Exception {
        Key key = generateKey(desKey);
        
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);//////////LINE 50
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    public static Key generateKey(String myEncryptionKey) throws Exception {
        byte[] keyAsBytes;
        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        Key key = new SecretKeySpec(keyAsBytes, ALGORITHM);
        return key;
    }
}
