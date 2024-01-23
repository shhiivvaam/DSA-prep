public class reverse_String_rec {
    public static String reverse(String str, int i, int j) {
        if(i>j) return str;

        char c[] = str.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        return reverse(new String(c), ++i, --j);
    }
    public static void main(String[] args) {
        String str = "Shivam";
        String new_str = reverse(str, 0, str.length()-1);

        System.out.println(new_str);
    }
}