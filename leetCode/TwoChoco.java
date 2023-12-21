package leetCode;

import java.util.Arrays;

public class TwoChoco {
    public int buyChoco_2ndMethod(int[] prices, int money) { // time complexity - O(n log n)
        Arrays.sort(prices);
        int res = money - prices[0] - prices[1];
        return res >= 0 ? res : money;
    }

    public int buyChoco(int[] prices, int money) { // time complexity - O(n)
        int lowest = Integer.MAX_VALUE;
        int nextLowest = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (lowest >= prices[i]) {
                nextLowest = lowest;
                lowest = prices[i];
            } else if (nextLowest > prices[i]) {
                nextLowest = prices[i];
            }
        }
        int res = money - lowest - nextLowest;
        return res >= 0 ? res : money;
    }
}
