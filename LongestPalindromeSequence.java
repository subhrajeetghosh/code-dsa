public class LongestPalindromeSequence {
    int res = 0;

    public int longestPalindromeSubseqRecursionMethod(String s) {
        recusion(0, new boolean[s.length()], new StringBuilder(), s);
        return res;
    }

    public void recusion(int index, boolean[] visited, StringBuilder sb, String str) {
        if (index >= str.length()) {
            return;
        }
        if (isPalindrome(sb)) {
            res = Math.max(res, sb.length());
        }
        for (int i = index; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(str.charAt(i));
                recusion(i + 1, visited, sb, str);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public boolean isPalindrome(StringBuilder sb) {
        int i = 0, j = sb.length() - 1;
        while (i <= j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    // better method to write this
    public int longestPalindromeSubseqDpSolution(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j=i+1; j<n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2+dp[i+1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
    int[][] arr;

    public int longestPalindromeSubseq(String s) {
        arr = new int[s.length()][s.length()];
        return recusionForMemorization(arr, 0, s.length()-1, s);
    }

    public int recusionForMemorization(int[][] arr, int i, int j, String s) {
        if(i == j) return 1;
        else if(i > j) return 0;
        if(arr[i][j]!=0) return arr[i][j];
        if(s.charAt(i) == s.charAt(j)) {
            arr[i][j] = 2 + recusionForMemorization(arr, i+1, j-1, s);
        }
        else {
            arr[i][j] = Math.max(recusionForMemorization(arr, i+1, j, s),
            recusionForMemorization(arr, i, j-1, s));
        }        
        return arr[i][j];
    }

    public static void main(String[] args) {
        LongestPalindromeSequence obj = new LongestPalindromeSequence();
        //System.out.println(obj.longestPalindromeSubseq("aba"));
        System.out.println(obj.longestPalindromeSubseqDpSolution("aba"));
    }
}

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence
 */