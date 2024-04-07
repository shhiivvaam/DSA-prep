public class reverse_words_in_string {
    public static void main(String[] args) {
        String str = "  a good   example  ";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }

    // public static String reverseWords(String s) {
    // s = s.replaceAll("\\s+", " ");
    // String[] str = s.trim().split(" ");
    // StringBuilder ans = new StringBuilder();
    // for (int i = 0; i < str.length; i++) {
    // StringBuilder sb = new StringBuilder(str[i]);
    // if (i == str.length - 1)
    // ans.append(sb.reverse().toString());
    // else
    // ans.append(sb.reverse().toString() + " ");
    // }
    // return ans.reverse().toString();
    // }
}
