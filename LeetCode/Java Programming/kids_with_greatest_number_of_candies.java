import java.util.*;

public class kids_with_greatest_number_of_candies {
    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        List<Boolean> list = kidsWithCandies(candies, extraCandies);

        for (boolean i : list) {
            System.out.print(i + " ");
        }

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();

        int max = -1;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }
}
