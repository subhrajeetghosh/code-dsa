package leetCode;

/**
 * https://leetcode.com/problems/water-bottles/
 * 
 * @author subhrajeetghosh
 */
public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) { // time complexity - O(n)
        int count = 0;
        int leftNumBottles = 0;
        while (numBottles + leftNumBottles >= numExchange) {
            count += numBottles;
            numBottles += leftNumBottles;
            leftNumBottles = numBottles % numExchange;
            numBottles /= numExchange;
        }
        return count + numBottles;
    }
}
