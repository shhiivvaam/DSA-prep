public class palindrome_rec2 {
    public static Boolean checkP(String str) {
        if (str.isEmpty() || str.length() == 1)
            return true;

        if (str.charAt(0) != str.charAt(str.length() - 1))
            return false;

        return checkP(str.substring(1, str.length() - 1));

    }

    public static void main(String[] args) {
        String str = "noon";

        boolean ans = checkP(str);

        if (ans)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
