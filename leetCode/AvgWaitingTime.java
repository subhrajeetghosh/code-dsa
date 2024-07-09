package leetCode;

/**
 * https://leetcode.com/problems/average-waiting-time
 * 
 * @author subhrajeetghosh
 */
public class AvgWaitingTime {
    public double averageWaitingTime(int[][] customers) { // time complexity - O(n)
        double totalTime = 0;
        int currentTime = 0;
        for (int[] customer : customers) {
            currentTime = Math.max(customer[0], currentTime) + customer[1];
            totalTime += (double) currentTime - customer[0];
        }

        return totalTime / customers.length;
    }
}
