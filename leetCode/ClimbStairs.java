package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs
 * 
 * @author subrajeetghosh
 */
public class ClimbStairs {
    Map<Integer, Integer> map = new HashMap<>();

    // memorized approch with recursion
    public int climbStairs(int n) {
        map.put(1, 1);
        map.put(2, 2);
        return rec(n);
    }

    public int rec(int n) {
        if (map.containsKey(n))
            return map.get(n);
        map.put(n, rec(n - 1) + rec(n - 2));
        return map.get(n);
    }

    // dp approch
    public int climbStairs_2ndMethod(int n) {
        if (n < 2)
            return 1;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
