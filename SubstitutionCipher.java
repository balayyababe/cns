public class SubstitutionCipher {

    static String substitute(String s, boolean decrypt) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "QWERTYUIOPASDFGHJKLZXCVBNM";

        StringBuilder out = new StringBuilder();

        s = s.toUpperCase();

        for (char c : s.toCharArray()) {

            if (c >= 'A' && c <= 'Z') {

                int i = decrypt
                    ? key.indexOf(c)
                    : alphabet.indexOf(c);

                out.append(decrypt
                    ? alphabet.charAt(i)
                    : key.charAt(i));

            } else {
                out.append(c);
            }
        }

        return out.toString();
    }

    public static void main(String[] args) {

        String text = "HELP";

        String encrypted = substitute(text, false);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = substitute(encrypted, true);
        System.out.println("Decrypted: " + decrypted);
    }
}
