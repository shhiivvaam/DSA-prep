package Microsoft;


public class domino_seq {
    public static void main(String[] args) {

        int[] A1 = {2, 4, 1, 3, 4, 6, 2, 4, 1, 6};
        int[] A2 = {5, 1, 2, 6, 6, 1, 3, 1, 4, 3, 4, 3, 4, 6, 1, 2, 4, 1, 6, 2};
        int[] A3 = {1, 5, 3, 3, 1, 3};
        int[] A4 = {3, 4};
        
        System.out.println(solution(A1));  
        System.out.println(solution(A2));  
        System.out.println(solution(A3));  
        System.out.println(solution(A4));  
    }

    public static int solution(int[] A) {
        int count = 0;  
        int N = A.length / 2;  

        for (int i = 0; i < N; i++) {
            int left1 = A[2 * i];
            int right1 = A[2 * i + 1];

            boolean isValid = false;

            if (i < N - 1) {
                int left2 = A[2 * (i + 1)];
                int right2 = A[2 * (i + 1) + 1];
                if (left1 == left2 || left1 == right2 || right1 == left2 || right1 == right2) isValid = true;
            }
            if (!isValid) count++;
        }
        return count;
    }
}
