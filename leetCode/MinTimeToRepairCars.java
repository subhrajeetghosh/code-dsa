package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-to-repair-cars
 * 
 * @author subhrajeetghosh
 */
public class MinTimeToRepairCars {
    long result = Long.MAX_VALUE;

    // Brute Force
    public long repairCars_2ndMethod(int[] ranks, int cars) { // time complexity - O(n^m)
        backtrack(ranks, 0, cars, new long[ranks.length]);
        return result;
    }

    private void backtrack(int[] ranks, int index, int cars, long[] timeTaken) {
        if (cars == 0) {
            result = Math.min(result, maxTime(timeTaken));
            return;
        }
        if (index >= ranks.length)
            return;

        for (int i = 0; i <= cars; i++) {
            timeTaken[index] = (long) ranks[index] * i * i;
            backtrack(ranks, index + 1, cars - i, timeTaken);
        }
    }

    private long maxTime(long[] timeTaken) {
        long max = 0;
        for (long time : timeTaken)
            max = Math.max(max, time);
        return max;
    }

    // Brute Force approach 2
    public long repairCars_4thMethod(int[] ranks, int cars) { // time complexity - O(n^m)
        repairTimeChecker(ranks, 0, cars, new ArrayList<>());
        return result;
    }

    private void repairTimeChecker(int[] ranks, int index, int currentCars, List<Long> timeTaken) {
        if (currentCars == 0) {
            long currentMaxTime = 0;
            for (long time : timeTaken) {
                currentMaxTime = Math.max(currentMaxTime, time);
            }
            result = Math.min(result, currentMaxTime);
            return;
        }
        if (index >= ranks.length) {
            return;
        }
        int totalCars = currentCars;
        while (currentCars > 0) {
            timeTaken.add((long) (ranks[index] * (totalCars - currentCars) * (totalCars - currentCars)));
            repairTimeChecker(ranks, index + 1, currentCars, timeTaken);
            timeTaken.remove(timeTaken.size() - 1);
            currentCars--;
        }
    }

    // Binery Search bit optimized
    public long repairCars_3rdMethod(int[] ranks, int cars) { // time complexity - O(n sqrt(m) log m)
        long result = Long.MAX_VALUE;
        for (int rank : ranks) {
            result = Math.min(result, 1L * rank * cars * cars);
        }
        long left = 0, right = (long) 1e14;
        while (left < right) {
            long mid = left + (right - left) / 2;
            int k = 0;
            for (int i = 0; i < ranks.length; i++) {
                int currentCars = 1;
                while (ranks[i] * currentCars * currentCars <= mid) {
                    currentCars++;
                }
                k += currentCars - 1;
            }
            if (k >= cars)
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }

    // Binery Search more optimized
    public long repairCars(int[] ranks, int cars) { // time complexity - O(n log m)
        long result = Long.MAX_VALUE;
        for (int rank : ranks) {
            result = Math.min(result, 1L * rank * cars * cars);
        }
        long left = 0, right = result;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long k = 0;
            for (int rank : ranks) {
                k += (long) Math.sqrt((double) mid / rank);
            }
            if (k >= cars)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
