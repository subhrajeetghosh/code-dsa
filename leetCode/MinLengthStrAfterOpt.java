package leetCode;

/**
 * https://leetcode.com/problems/minimum-length-of-string-after-operations
 * 
 * @author subhrajeetghosh
 */
public class MinLengthStrAfterOpt {
    public int minimumLength(String s) { // time complexity - O(n)
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 2) {
                result += arr[i] % 2 == 0 ? 2 : 1;
            } else {
                result += arr[i];
            }
        }
        return result;
    }
}
