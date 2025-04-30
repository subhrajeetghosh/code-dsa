package leetCode;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * 
 * @author subhrajeetghosh
 */
public class FindNumberEvenNumberDigit {
    public int findNumbers(int[] nums) { // time complexity - O(n*d)
        int result = 0;
        for (int num : nums) {
            int count = 0;
            while (num != 0) {
                num /= 10;
                count++;
            }
            if (count % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public int findNumbers_2ndMethod(int[] nums) { //time complexity - O(n*d)
        int result = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
