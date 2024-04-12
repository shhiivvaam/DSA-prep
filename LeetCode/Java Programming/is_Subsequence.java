public class is_Subsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
    public static boolean isSubsequence(String s, String t) {
        // Good Solution

        int i = 0;
        int j = 0;
        while(i<s.length() && j<t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else j++;
        }
        return i == s.length();


        // 1

        // int j = 0;
        // for(int i = 0;i<t.length() && j<s.length();i++) {
        //     if(s.charAt(j) == t.charAt(i)) j++;
        // }

        // return j == s.length();


        // 2

        // for(int i = 0;i<s.length();i++) {
        //     boolean flag = false;
        //     for(int j = 0;j<t.length();j++) {
        //         if(s.charAt(i) == t.charAt(j)) flag = true;
        //     }
        //     if(!flag) return false;
        // }
        // return true;
    }
}
