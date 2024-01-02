package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 * 
 * @author subhrajeetghosh
 */

public class AssignCookie {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int m = g.length, n = s.length;
        while (i < m && j < n) {
            if (g[i] <= s[j]) {
                res++;
                i++;
            }
            j++;
        }
        return res;
    }
}
