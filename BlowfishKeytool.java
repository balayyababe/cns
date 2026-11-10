//RUN IN TERMINAL BEFORE code
//keytool -genseckey -alias blowfishkey -keyalg Blowfish -keysize 128 -keystore lab.jceks -storetype JCEKS

import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.util.Base64;

public class BlowfishKeytool {
    public static void main(String[] args) throws Exception {
        char[] password = System.console() != null
            ? System.console().readPassword("Keystore password: ")
            : "changeit".toCharArray(); // Replace if needed

        KeyStore ks = KeyStore.getInstance("JCEKS");
        try (FileInputStream in = new FileInputStream("lab.jceks")) {
            ks.load(in, password);
        }

        Key key = ks.getKey("blowfishkey", password);
        Cipher cipher =
            Cipher.getInstance("Blowfish/ECB/PKCS5Padding");

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
