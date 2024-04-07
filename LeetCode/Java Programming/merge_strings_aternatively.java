public class merge_strings_aternatively {
    public static void main(String[] args) {
        String one = "abc";
        String two = "pqr";
        System.out.println(mergeAlternately(one, two));
    }

    // letcode Functions
    public static String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();
        while (i < n && j < m) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        while (i < n) {
            sb.append(word1.charAt(i++));
        }
        while (j < m) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
