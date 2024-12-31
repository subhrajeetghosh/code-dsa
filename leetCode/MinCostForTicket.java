package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets
 * 
 * @author subhrajeetghosh
 */
public class MinCostForTicket {
    Map<Integer, Integer> memo;

    public int mincostTickets(int[] days, int[] costs) { //time complexity - O(3*n)
        memo = new HashMap<Integer, Integer>();
        return backtrack(days, costs, 0, 0);
    }

    private int backtrack(int[] days, int[] costs, int index, int currentTicket) {
        if (index >= days.length) {
            return 0;
        }
        int key = index * 1000 + currentTicket;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int minCost = 0;
        if (currentTicket < days[index]) {
            minCost = Math.min(costs[0] + backtrack(days, costs, index + 1, days[index]),
                    Math.min(costs[1] + backtrack(days, costs, index + 1, days[index] + 6),
                            costs[2] + backtrack(days, costs, index + 1, days[index] + 29)));
        } else {
            minCost = backtrack(days, costs, index + 1, currentTicket);
        }
        memo.put(key, minCost);
        return minCost;
    }
}
