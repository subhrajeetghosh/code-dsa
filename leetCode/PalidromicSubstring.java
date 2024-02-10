package leetCode;

/**
 * https://leetcode.com/problems/palindromic-substrings
 * 
 * @author subhrajeetghosh
 */

public class PalidromicSubstring {
    public int countSubstrings(String s) {  //time complexity = O(n^2)
        int count = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count += countMethod(arr, i, i);
            count += countMethod(arr, i, i + 1);
        }
        return count;
    }

    public int countMethod(char[] arr, int left, int right) {
        int count = 0;
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
