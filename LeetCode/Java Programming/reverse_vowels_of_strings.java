public class reverse_vowels_of_strings {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(reverseVowels(str));
    }

    public static Boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I'
                || c == 'O' | c == 'U';
    }

    public static String reverseVowels(String str) {
        int i = 0;
        int j = str.length() - 1;

        StringBuilder s = new StringBuilder(str);

        while (i <= j) {
            if (isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
                char c = s.charAt(i);
                s.setCharAt(i, s.charAt(j));
                s.setCharAt(j, c);
                i++;
                j--;
            } else if (isVowel(s.charAt(i)) && !isVowel(s.charAt(j)))
                j--;
            else if (!isVowel(s.charAt(i)) && isVowel(s.charAt(j)))
                i++;
            else {
                i++;
                j--;
            }
        }
        return s.toString();
    }
}