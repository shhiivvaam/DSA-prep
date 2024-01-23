public class good_Subarray {

    static int good_Subarray1(int[] arr) {
        int n = arr.length;
        int freq[] = new int[n];
        int sum = 0;

        freq[0] = 1;
        for(int i = 0;i<freq.length;i++) {
            sum += arr[i];
            int idx = (int)(sum%n);
            // sum = sum%n;
            
            if(idx <0) idx += n;
            freq[idx] = freq[idx]+1;
        }


        // nCr formula      -> where the value of r == 2
        int ans = 0;
        for(int i = 0;i<freq.length;i++){
            if(freq[i] >=2 ){
                ans += ((freq[i]) * (freq[i]-1))/2;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        //? Good Subarray 
            // * The ques is to find the count of subarray exists in the array whose sum is divisible by some number k.

            // ? Pigeon Hole Principle         ( only way to solve this problem)

            int arr[] = { 1,2,3,4,8,16,15,14,13,5,6,7};
            System.out.println(good_Subarray1(arr));

    }
}
