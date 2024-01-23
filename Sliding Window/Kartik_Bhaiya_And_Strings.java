public class Kartik_Bhaiya_And_Strings {

    //! Question : 
    //? Kartik bhaiya has string consisting of only characters 'a' and 'b' as the characters. Kartik Bhaiya describes perfectness of a string as the maximum length substring of equal characers. Kartik Bhaiya is given a number k which denotes the maximum number of characters he can change. Find the maximum perfectness he can generate by changing no more than k characters.

    //* Sample Input */
    // 2
    // abba
    
    //* Sample Output */
    // 4

    //! explanaion:
    //? We can swap the a's to b using the 2 swaps and obtain the string 'bbbb'. This would have all the b's and hence the answer 4. Alternatively, we can swap the b's to make 'aaaa'. This final answer remains the same for both cases. 



    // function to find the lenght of the window that contains the character with k flips that makes the longest continuos same characters window
    // Remeber: the String only contains two characters that is, { a and b }
    public static int maximumLength(String str, int k, char c) {

        int start = 0;
        int end = 0;
        
        int ans = 0;
        int flip = 0;

        while(end < str.length()) {
            // window grow
            if(str.charAt(end) == c) flip++;

            // shrink window
            while(flip >k && start<=end) {
                if(str.charAt(start) == c) flip--;

                start++;
            }

            // calculate ans
            ans = Math.max(ans, end - start +1);

            end++;
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "abbbaababab";
        int k = 3;

        int flipA = maximumLength(str, k, 'a');
        int flipB = maximumLength(str, k, 'b');

        int max = Math.max(flipA, flipB);
        System.out.println(max);
    }
}