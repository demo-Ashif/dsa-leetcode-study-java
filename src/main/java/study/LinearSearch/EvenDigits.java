package study.LinearSearch;
/*
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */

public class EvenDigits {
    public static void main(String[] args) {
        int ans = findNumbers(new int[]{12, 345, 2, 6, 7896});
        System.out.println(ans);

    }

    static int findNumbers(int[] nums) {
        int result = 0;

        for (int num : nums) {
            int n = num;
            int digitCount = 0;
            while (n > 0) {
                n = n / 10;
                digitCount++;
            }

            if (digitCount % 2 == 0) {
                result += 1;
            }

        }

        return result;
    }
}
