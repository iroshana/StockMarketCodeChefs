/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author thari
 */
public class PasswordEncryptionService {
    
    public static String Encryption(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passwordByte = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1,passwordByte);
            String encryptPass = number.toString(16);
            while(encryptPass.length() < 32){
                encryptPass = "0"+ encryptPass;
            }
            return encryptPass;
        }catch(NoSuchAlgorithmException ex){
            throw new RuntimeException(ex);
        }
    }
}
