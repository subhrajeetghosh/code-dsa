package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop
 * 
 * @author subhrajeetghosh
 */
public class FinalPriceWithDiscount {

    //Bruteforce
    public int[] finalPrices_2ndMethod(int[] prices) { //time complexity - O(n^2)
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
    //Monotonic Stack
    public int[] finalPrices(int[] prices) { // time complexity - O(n)
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.add(i);
        }

        return prices;
    }
}
