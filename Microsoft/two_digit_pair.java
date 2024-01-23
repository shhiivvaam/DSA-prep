package Microsoft;

public class two_digit_pair {
    public static void main(String[] args) {

        int[] numbers1 = {50, 30, 15, 51, 10, 20, 15};
        int[] numbers2 = {11, 33, 55};

        System.out.println("Maximum pair sequence length for numbers1: " +  solution(numbers1));  // Output: 5
        System.out.println("Maximum pair sequence length for numbers2: " + solution(numbers2));  // Output: 1
    }

    public static int solution(int[] numbers) {
        int maxChosen = 1;  // Initialize with 1, as every number is a sequence of length at least 1

        for (int i = 0; i < numbers.length - 1; i++) {
            int currentCount = 1;  // Initialize with 1, as every number is a sequence of length at least 1

            for (int j = i + 1; j < numbers.length; j++) {
                if (haveCommonDigit(numbers[i], numbers[j])) {
                    currentCount++;
                }
            }

            maxChosen = Math.max(maxChosen, currentCount);
        }

        return maxChosen;
    }

    private static boolean haveCommonDigit(int x, int y) {
        while (x > 0) {
            int digit = x % 10;
            int temp = y;
            while (temp > 0) {
                if (digit == temp % 10) {
                    return true;
                }
                temp /= 10;
            }
            x /= 10;
        }
        return false;
    }
}
