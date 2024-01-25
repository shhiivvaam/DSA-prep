public class Coin_Combination {

    // ! Question :
    // ? We have infinite amount of supply of the coins and we have to print the
    // permutation of the coins that sums up to the given amount.
    // * The answer should contain all the possible cases that sums to the given
    // amount by taking any amount of coin any number of times */

    static void Coin_Combination1(int[] coin, int amount, String ans, int index) {
        if (amount == 0) {
            System.err.println(ans + " ");
            return;
        }

        for (int i = index; i < coin.length; i++) {
            if (amount >= coin[i]) {
                amount -= coin[i];
                Coin_Combination1(coin, amount, ans + coin[i], i);     // since we have infinite supply of coins, and so we are sending nex tindex as the current { i } value, and if we do not have any infinite supply then we would have set the index pass value here as { i +1 }, for considering the next following number, which would help us not forming any repetation of coins { ex : 2233 and 3322} that is permutations
                amount += coin[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] coin = { 2, 3, 5, 6 };
        int amount = 10;

        Coin_Combination1(coin, amount, "", 0);
    }
}