public class can_place_flowers {
    public static void main(String[] args) {
        int flowerbed[] = { 1, 0, 0, 0, 1 };
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        // edge cases
        // if the leght length of the flowerbed is only 1
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1)
            return true;
        if (flowerbed.length == 1 && flowerbed[0] == 1 && n >= 1)
            return false;

        // 2. When there are two continuous zeros in the start only
        if (flowerbed.length >= 2 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        // 3. When there are two continuos zeros in the end
        if (flowerbed.length > 2 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            n--;
        }

        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                if (n > 0)
                    n--;
                else
                    return true;
            }
        }
        return n <= 0;

        // This approach will fail for cases like -> [1,0,1,0,1,0,1]

        // int z = 0;
        // for(int i : flowerbed) if(i == 0) z++;

        // if((z> 2*n) || (z == 2*n && (flowerbed[0] == 0 ||
        // flowerbed[flowerbed.length-1] == 0))) return true;
        // else return false;
    }
}
