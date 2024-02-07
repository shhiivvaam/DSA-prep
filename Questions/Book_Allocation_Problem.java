import java.util.*;

public class Book_Allocation_Problem {
    public static void main(String[] args) {
        Scanner ask = new Scanner(System.in);
        int t = ask.nextInt();

        while (t-- > 0) {
        int n = ask.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
        a[i] = ask.nextInt();
        }
        int m = ask.nextInt();
        System.out.println("The book is allocated in the following order: " +
        minimumPages(a, m));
        }

        ask.close();

        // int page[] = { 10, 20, 30, 40 };
        // int nos = 2;
        // System.out.println(minimumPages(page, nos));
    }

    public static int minimumPages(int[] pages, int nos) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < pages.length; i++) {
            high += pages[i];
        }

        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(pages, mid, nos) == true) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] pages, int mid, int nos) {
        int student = 1;
        int read_page = 0;

        int i = 0;
        while (i < pages.length) {
            if (read_page + pages[i] <= mid) {
                read_page += pages[i];
                i++;
            } else {
                student++;
                read_page = 0;
            }
        }
        if (student > nos) {
            return false;
        }
        return true;
    }
}
