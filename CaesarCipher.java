public class CaesarCipher {

    static String caesar(String s, int key) {
        StringBuilder out = new StringBuilder();

        for (char c : s.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                out.append((char) ('A' +
                    (c - 'A' + key + 26) % 26));
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static void main(String[] args) {

        String text = "HELP";
        int shift = 3;

        String encrypted = caesar(text, shift);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = caesar(encrypted, -shift);
        System.out.println("Decrypted: " + decrypted);
    }
}
