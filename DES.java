
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class DES {
    public static void main(String[] args) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56);
        SecretKey key = kg.generateKey();

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

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
