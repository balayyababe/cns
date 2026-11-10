import java.security.MessageDigest;

public class SHA1 {
    public static void main(String[] args) throws Exception {
        String text = "Hello world";

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(text.getBytes("UTF-8"));

        StringBuilder hex = new StringBuilder();

        for (byte b : digest) {
            hex.append(String.format("%02x", b & 0xff));
        }

        System.out.println("Original text: " + text);
        System.out.println("SHA-1 digest: " + hex);
    }
}
