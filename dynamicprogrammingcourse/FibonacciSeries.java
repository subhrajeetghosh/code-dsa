package dynamicprogrammingcourse;

import java.util.HashMap;
import java.util.Map;

/**
 * fibonacci Series
 * 
 * @author subhrajeetghosh
 */

public class FibonacciSeries {
    Map<Integer, Integer> map = new HashMap<>();

    // recusion
    public int fibonacciRec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    // Memorization
    public int fibonacciMemorization(int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n <= 2) {
            return 1;
        }
        map.put(n, fibonacciMemorization(n - 1) + fibonacciMemorization(n - 2));
        return map.get(n);
    }

    // dp
    public int FibonacciSeriesDP(int n) {
        if (n == 0 || n == 1)
            return n;
        int first = 0;
        int second = 1;
        int currentNum = 0;
        for (int i = 2; i <= n; i++) {
            currentNum = first + second;
            first = second;
            second = currentNum;
        }
        return currentNum;
    }

    public static void main(String[] args) {
        FibonacciSeries obj = new FibonacciSeries();
        System.out.println(obj.fibonacciMemorization(9));
        System.out.println(obj.FibonacciSeriesDP(9));

    }
}

/*
 * Dynamic Programing course from the freecodcamp youtube
 */