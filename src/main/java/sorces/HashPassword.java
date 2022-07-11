package sorces;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

    public static StringBuilder hashPassword(String password) {
        byte[] bytes;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            bytes = messageDigest.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (Byte b : bytes) {
            stringBuilder.append(String.format("%02X",b));
        }
        return stringBuilder;
    }
}
