
package aesencryption;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;


public class AESEncryption {
//encrypt method
    public static String encrypt(String key, String initializeVector, String val) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initializeVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(val.getBytes());
            System.out.println("encrypted string:" + DatatypeConverter.printBase64Binary(encrypted));//outputs encrypted message

            return DatatypeConverter.printBase64Binary(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String initVector, String ciphertext) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(ciphertext));

            return new String(original);//returns the decrypted message
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {//actual runnable program 
        String key = "1231231231231231"; // 128 bit key
        String initializeVector = "abcdefghijklmnop"; // 16 bytes IV
        String plainText = JOptionPane.showInputDialog("Input plain text");//gets message to be encrypted from user
        
        System.out.println("AES Encryption being used");//tells user which encryption method is being used
        System.out.println(decrypt(key, initializeVector,//calls decryption method
                encrypt(key, initializeVector, plainText)));//calls encryption method
    }
    
    
        
    }
    
    

