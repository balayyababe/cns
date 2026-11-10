public class HillCipher {

    static String hill(String s, boolean decrypt) {

        s = s.toUpperCase().replaceAll("[^A-Z]", "");

        if (s.length() % 2 != 0)
            s += "X";

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {

            int a = s.charAt(i) - 'A';
            int b = s.charAt(i + 1) - 'A';

            int x, y;

            if (!decrypt) {

                x = (3 * a + 3 * b) % 26;
                y = (2 * a + 5 * b) % 26;

            } else {

                // Inverse matrix modulo 26

                x = (15 * a + 17 * b) % 26;
                y = (20 * a + 9 * b) % 26;
            }

            out.append((char) ('A' + x));
            out.append((char) ('A' + y));
        }

        return out.toString();
    }

    public static void main(String[] args) {

        String text = "HELP";

        String encrypted = hill(text, false);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = hill(encrypted, true);
        System.out.println("Decrypted: " + decrypted);
    }
}
