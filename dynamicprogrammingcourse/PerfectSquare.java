package dynamicprogrammingcourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author subhrajeetghosh
 */
public class PerfectSquare {
    // Bruteforce Solution
    int result = Integer.MAX_VALUE;

    public int numSquares(int n) {
        int m = 1;
        List<Integer> list = new ArrayList<Integer>();
        while (m * m <= n) {
            list.add(m * m);
            m++;
        }
        dfs(n, list, 0, 0);
        return result;
    }

    private void dfs(int n, List<Integer> list, int index, int count) {
        if (n == 0 && result > count) {
            result = count;
            return;
        }
        if (n < 0 || list.size() <= index) {
            return;
        }
        dfs(n, list, index + 1, count);
        dfs(n - list.get(index), list, index, count + 1);
        dfs(n - list.get(index), list, index + 1, count + 1);
    }

    // Memorization
    int result1 = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();

    public int numSquares_2ndMethod(int n) {
        int m = 1;
        List<Integer> list = new ArrayList<Integer>();
        while (m * m <= n) {
            list.add(m * m);
            m++;
        }
        dfs_2ndMethod(n, list, 0, 0);
        return result1;
    }

    private void dfs_2ndMethod(int n, List<Integer> list, int index, int count) {
        if (n == 0 && result > count) {
            result1 = count;
            return;
        }
        if (n < 0 || list.size() <= index) {
            return;
        }
        if (map.containsKey(n) && map.get(n) <= count) {
            return;
        }
        dfs(n, list, index + 1, count);
        dfs(n - list.get(index), list, index, count + 1);
        dfs(n - list.get(index), list, index + 1, count + 1);
        map.put(n, count);
    }
}
