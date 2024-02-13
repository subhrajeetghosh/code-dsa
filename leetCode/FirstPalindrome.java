package leetCode;

/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array
 * 
 * @author subhrajeetghosh
 */
public class FirstPalindrome {
    public String firstPalindrome(String[] words) { // time complexity - O(n * m/2)
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i].toCharArray())) {
                return words[i];
            }
        }
        return "";
    }

    private boolean isPalindrome(char[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (arr[start] != arr[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}
