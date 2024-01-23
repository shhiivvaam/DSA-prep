public class Trapping_Rain_Water {

    // ! The below code is wrong
    // static int Trapping_Rain_Water1(int[] arr) {
    // int max = arr[0];
    // int sec = max;

    // for (int i = 1; i < arr.length; i++) {
    // if (arr[i] > max) {
    // sec = max;
    // max = arr[i];
    // }
    // }

    // int ans = 0;
    // for (int i = 0; i < arr.length; i++) {
    // ans += (sec - arr[i]);
    // }
    // return ans;
    // }

    static int Trapping_Rain_Water1(int[] arr) {

        //? steps:
            //* 1. take two arrays left and right
            //* 2. in the left array keep a count of the left max height
            //* 3. in the right array keep a count of the right max height
            //* 4. now since we have to return the final ans and not the updated height array
            //* 5. now start traversing with the given height array
            //* 6. take a ans variable and in the ans keep the difference between the current array height and the min of(left and right array of the current index) 


        int left[] = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        int right[] = new int[arr.length];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += Math.min(left[i], right[i]) - arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(Trapping_Rain_Water1(arr));
    }
}
