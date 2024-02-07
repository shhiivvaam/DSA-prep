import java.util.*;

public class Agressive_Cows {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);

        int test = ask.nextInt();
        while (test-- > 0) {
            int nos = ask.nextInt(); // no of stalls
            int noc = ask.nextInt(); // no of cows
            int[] stalls = new int[nos];
            for (int i = 0; i < stalls.length; i++) {
                stalls[i] = ask.nextInt();
            }
            
            Arrays.sort(stalls);
            System.out.println(largestMinDistance(stalls, noc));
        }


        ask.close();
    }

    public static int largestMinDistance(int[] stalls, int noc) {
        int low = 0;
        int high = stalls[stalls.length - 1] - stalls[0]; // 9-1

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(stalls, mid, noc) == true) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] stalls, int mid, int noc) {
        int cows = 1;
        int position = stalls[0];

        int i = 1;
        while (i < stalls.length) {
            if (stalls[i] - position >= mid) {
                cows++;
                position = stalls[i];
            }

            if (cows == noc) {
                return true;
            }
            i++;
        }
        return false;
    }
}