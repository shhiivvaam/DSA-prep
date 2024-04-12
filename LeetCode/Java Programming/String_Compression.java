public class String_Compression {
    public static void main(String[] args) {
        // char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        char[] chars = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {

        if (chars.length == 1)
            return 1;

        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
                count++;
            }
            count++;
            chars[index++] = chars[i];
            if (count == 1)
                continue;
            if (count < 10)
                chars[index++] = (char) (count + '0');
            else {
                StringBuilder sb = new StringBuilder(count + "");
                char countArr[] = sb.toString().toCharArray();
                for (int j = 0; j < countArr.length; j++) {
                    chars[index++] = countArr[j];
                }
            }
        }
        return index;
    }
}