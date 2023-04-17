public class DistinctSubsequence {
    int res = 0;
    String str;

    public int numDistinctRecursion(String s, String t) {
        str = t;
        isSame(s, 0, new boolean[s.length()], new StringBuilder());
        return res;
    }

    public void isSame(String s, int index, boolean[] visited, StringBuilder sb) {
        if (sb.toString().equals(str)) {
            res++;
            return;
        }
        if (index >= s.length() || sb.length() > str.length())
            return;
        for (int i = index; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(s.charAt(i));
                isSame(s, i + 1, visited, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public int numDistinct(String s, String t) {
        int[][] arr = new int[s.length()][t.length()];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0) {
                    arr[i][j] = 1;
                } else if (j == 0) {
                    arr[i][j] = 0;
                } else if (s.charAt(i) == t.charAt(j)) {
                    arr[i][j] = Math.max(arr[i - 1][j], 1 + arr[i][j - 1]);
                } else {
                    arr[i][j] = arr[i][j - 1];
                }
            }
        }
        return arr[s.length()][t.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequence ds = new DistinctSubsequence();
        System.out.println(ds.numDistinct("babgbag", "bag"));
    }
}

/**
 * https://leetcode.com/problems/distinct-subsequences/description/
 */