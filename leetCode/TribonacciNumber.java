package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number
 * 
 * @author subhrajeetghosh
 */
public class TribonacciNumber {

    Map<Integer, Integer> map = new HashMap<>();

    // Memorization approch
    public int tribonacci(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        if (map.containsKey(n))
            return map.get(n);

        map.put(n, tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1));

        return map.get(n);
    }

    // Iterative approch
    public int tribonacci_2ndMethod(int n) {
        if (n < 2)
            return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
