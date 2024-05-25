package leetCode;

/**
 * https://leetcode.com/problems/integer-to-roman
 * 
 * @author subhrajeetghosh
 */
public class IntergerToRoman {
    public String intToRoman(int num) { // time complexity - O(num) generally O(1)
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] keys = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(keys[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
