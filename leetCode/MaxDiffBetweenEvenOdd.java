package leetCode;

/**
 * https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
 * 
 * @author subhrajeetghosh
 */
public class MaxDiffBetweenEvenOdd {
    public int maxDifference(String s) { // time complexity - O(n)
        int[] chArr = new int[26];
        int odd = 0, even = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            chArr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (chArr[i] != 0 && chArr[i] % 2 == 0) {
                even = Math.min(even, chArr[i]);
            } else if (chArr[i] % 2 == 1) {
                odd = Math.max(odd, chArr[i]);
            }
        }
        return odd - even;
    }
}
