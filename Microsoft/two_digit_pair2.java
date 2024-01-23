package Microsoft;

import java.util.*;

public class two_digit_pair2 {
    public static void main(String[] args) {

        int[] numbers1 = { 50, 30, 15, 51, 10, 20, 15 };
        int[] numbers2 = { 11, 33, 55 };

        System.out.println("Maximum pair sequence length for numbers1: " + solution(numbers1));
        System.out.println("Maximum pair sequence length for numbers2: " + solution(numbers2));
    }

    public static int solution(int[] numbers) {
        int maxChosen = 0;

        for (int i = 0; i < numbers.length; i++) {
            Set<Integer> uniqueDigits = new HashSet<>();
            int currentCount = 1;
            while (numbers[i] > 0) {
                uniqueDigits.add(numbers[i] % 10);
                numbers[i] /= 10;
            }

            for (int j = i + 1; j < numbers.length; j++) {
                int temp = numbers[j];
                while (temp > 0) {
                    if (uniqueDigits.contains(temp % 10)) {
                        currentCount++;
                        break;
                    }
                    temp /= 10;
                }
            }
            maxChosen = Math.max(maxChosen, currentCount);
        }
        return maxChosen;
    }
}
