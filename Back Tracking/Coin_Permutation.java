public class Coin_Permutation {

    //! Question :
        //? We have infinite amount of supply of the coins and we have to print the permutation of the coins that sums up to the given amount.
        //* The answer should contain all the possible cases that sums to the given amount by taking any amount of coin any number of times */

    static void coin_permuatation1(int[] coin, int amount, String ans) {
        if(amount == 0) {
            System.err.println(ans+ " ");
            return;
        }

        for(int i = 0;i<coin.length;i++) {
            if(amount >= coin[i]) {
                amount -= coin[i];
                coin_permuatation1(coin, amount, ans+coin[i]);
                amount += coin[i];
            }
        }
    }
    public static void main(String[] args) {
        int[] coin = {2, 3, 5, 6};
        int amount = 10;

        coin_permuatation1(coin, amount, "");
    }
}