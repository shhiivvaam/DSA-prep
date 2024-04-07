public class greatest_common_divisor_of_strings {
    public static void main(String[] args) {
        String one = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String two = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(gcdOfStrings(one, two));
    }
    public static String gcdOfStrings(String str1, String str2) {
        // Approach :
        //*  check stringg -> (a+b) == (b+a) if yes { check for the gcd } else { return ""; }
        
        if((str1+str2).equals(str2+str1)) {
            // check for gcd
            int gcd = findgcd(str1.length(), str2.length());
            return str1.substring(0, gcd);
        } else return "";

        // Wrong Approach
        // HashMap<Character, Integer> map = new HashMap<>();
        // for(char c: str2.toCharArray()) map.put(c, map.getOrDefault(c, 0) +1);
        // for(char c: str1.toCharArray()) {
        //     if(!map.containsKey(c)) return "";
        // }

        // int n = str1.length();
        // int m = str2.length();

        // int i = 0;
        // int j = 0;
        // String ans = "";

        // while(i<n) {
        //     if(j == m) break;
        //     if(str1.charAt(i) == str2.charAt(j)) {
        //         ans += str2.charAt(j);
        //         j++;
        //     } else {
        //         j = 0;
        //         ans = "";
        //     }
        //     i++;
        // }
        
        // int index = ans.length()%2 == 0 ? ans.length()/2 : ans.length()/2 +1;

        // if(ans.substring(0, index).equals(ans.substring(index))) return ans.substring(0, index);
        // else return ans;
    }
    public static int findgcd(int one, int two) {
        return two == 0 ? one : findgcd(two, one%two);
    }
}
