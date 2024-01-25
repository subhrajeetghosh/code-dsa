package dynamicprogrammingcourse;

/**
 * https://leetcode.com/problems/longest-common-subsequence
 * 
 * @author subhrajeetghosh
 */
public class LongestCommonSubSeq {

    //Bruteforce approch recursion
    public int longestCommonSubsequence_2ndMethod(String text1, String text2) {
        return rec(text1, text2, 0, 0);
    }

    private int rec(String text1, String text2, int i, int j) {
        if(text1.length() <= i || text2.length() <= j) return 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + rec(text1, text2, i+1, j+1);
        } else {
            return Math.max(rec(text1, text2, i+1, j), rec(text1, text2, i, j+1));
        }
    }

    //Bruteforce approch using memorization
    Integer[][] memo;
    public int longestCommonSubsequence_3rdMethod(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        return rec_1(text1, text2, 0, 0);
    }

    private int rec_1(String text1, String text2, int i, int j) {
        if(text1.length() <= i || text2.length() <= j) return 0;
        if(memo[i][j] != null) return memo[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + rec(text1, text2, i+1, j+1);
        } else {
            memo[i][j] = Math.max(rec(text1, text2, i+1, j), rec(text1, text2, i, j+1));
        }
        return memo[i][j];
    }

    //dp approch
    public int longestCommonSubsequence(String text1, String text2) { // time coplexity - O(m*n)
        int[][] arr = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[text1.length()][text2.length()];
    }
}
