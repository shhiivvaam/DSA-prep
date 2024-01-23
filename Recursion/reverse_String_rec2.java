public class reverse_String_rec2 {
    public static String reverseString(String str) {
        if(str.isEmpty() || str.length() == 1) return str;

        String new_str = str.substring(1);            // will leave the first character and will return the String from the second character to the new_str

        return reverseString(new_str) + str.charAt(0);
    }
    public static void main(String[] args) {
        String str = "Shivam";
        System.out.println(reverseString(str));
    }
}
