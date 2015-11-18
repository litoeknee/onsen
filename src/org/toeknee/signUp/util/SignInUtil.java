package org.toeknee.signUp.util;

/**
 * Created by toeknee on 11/18/15.
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignInUtil {
    // same as the token in weChat server
    private static String token = "onsen";

    /**
     * check the signature
     *
     * @param signature encoded signature from weChat
     * @param timestamp timestamp from weChat
     * @param nonce a random number from weChat
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        // sort the token, timestamp and nonce
        String[] paramArr = new String[] { token, timestamp, nonce };
        Arrays.sort(paramArr);

        // combine the answer as a string
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

        String ciphertext = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // encode the string using SHA1
            byte[] digest = md.digest(content.toString().getBytes());
            ciphertext = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // compare the SHA-1 encoding string with the signature from weChat
        return ciphertext != null ? ciphertext.equals(signature.toUpperCase()) : false;
    }

    /**
     * convert a byteArray to a String
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * convert a byte to a String in Hex
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }
}
