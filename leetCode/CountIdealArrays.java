package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-the-number-of-ideal-arrays
 * 
 * @author subhrajeetghosh
 * 
 * not sovled optimally
 */
public class CountIdealArrays {
    // Bruteforce approch
    int count = 0;
    int mod = 1000000007;

    public int idealArrays(int n, int maxValue) { // time complexity - (maxValue^n)
        for (int i = 1; i <= maxValue; i++) {
            findIdeals(n, maxValue, i, 1);
        }
        return count;
    }

    private void findIdeals(int n, int maxValue, int prev, int pos) {
        if (pos == n) {
            count++;
            count %= mod;
            return;
        }
        for (int i = 1; i * prev <= maxValue; i++) {
            findIdeals(n, maxValue, prev * i, pos + 1);
        }
    }

    Map<String, Long> memo;

    public int idealArrays_2ndMethod(int n, int maxValue) { //time complexity - O(maxValue * n * log(maxValue))
        memo = new HashMap<>();
        long count = 0;
        for (int i = 1; i <= maxValue; i++) {
            count = (count + findIdeals_1(n, maxValue, i, 1)) % mod;
        }
        return (int) count;
    }

    private long findIdeals_1(int n, int maxValue, int prev, int pos) {
        if (pos == n) {
            return 1;
        }
        String key = prev + " " + pos;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        long count = 0;
        for (int i = 1; i * prev <= maxValue; i++) {
            count = (count + findIdeals_1(n, maxValue, prev * i, pos + 1)) % mod;
        }
        memo.put(key, count);
        return count;
    }
}
