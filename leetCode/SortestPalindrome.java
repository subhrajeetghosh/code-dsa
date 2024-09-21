package leetCode;

/**
 * https://leetcode.com/problems/shortest-palindrome
 * 
 * @author subhrajeetghosh
 */
public class SortestPalindrome {
    int currentMax = -1;

    public String shortestPalindrome_2ndMethod(String s) { // time complexity - O(n^2)
        for (int i = 0; i <= s.length() / 2; i++) {
            currentMax = Math.max(currentMax, palindromeCheck(s, i, i));
            currentMax = Math.max(currentMax, palindromeCheck(s, i, i + 1));
        }
        if (currentMax == -1) {
            return new StringBuilder(s).reverse().append(s).toString();
        } else if (currentMax == s.length()) {
            return s;
        }
        return new StringBuilder(s.substring(currentMax)).reverse().append(s).toString();
    }

    private int palindromeCheck(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            } else {
                return -1;
            }
        }
        return left < 0 ? right : -1;
    }

    public String shortestPalindrome(String s) {
        String combine = new StringBuilder(s).append("$").append(new StringBuilder(s).reverse()).toString();

        int[] memo = new int[combine.length()];
        for(int i=1; i<combine.length(); i++) {
            int j = memo[i-1];
            while(j > 0 && combine.charAt(i) != combine.charAt(j)) {
                j = memo[j-1];
            }
            if(combine.charAt(i) == combine.charAt(j)) {
                j++;
            }
            memo[i] = j;
        }

        return new StringBuilder(s.substring(memo[combine.length()-1])).append(new StringBuilder(s)).toString();
    }

    public static void main(String[] args) {
        new SortestPalindrome().shortestPalindrome("aacecaaa");
    }
}
