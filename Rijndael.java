import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class Rijndael {
    public static void main(String[] args) throws Exception {
        byte[] keyBytes =
            "0123456789ABCDEF".getBytes("UTF-8");

        SecretKey key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        String text = "Hello world";

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));

        System.out.println("Encrypted: " +
            Base64.getEncoder().encodeToString(encrypted));

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Decrypted: " +
            new String(decrypted, "UTF-8"));
    }
}
