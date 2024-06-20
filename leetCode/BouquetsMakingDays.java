package leetCode;

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
 * 
 * @author subhrajeetghosh
 */
public class BouquetsMakingDays {
    public int minDays(int[] bloomDay, int m, int k) {  //time complexity - O(n)+O(log(maxDate−minDate))×O(n)
        long totalFlower = m * k;
        if (totalFlower > bloomDay.length)
            return -1;
        int minDate = Integer.MAX_VALUE;
        int maxDate = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            minDate = Math.min(minDate, day);
            maxDate = Math.max(day, maxDate);
        }
        int result = -1;
        while (minDate <= maxDate) {
            int currentDay = (minDate + maxDate) / 2;
            if (possiblityOfBlloming(bloomDay, m, k, currentDay)) {
                result = currentDay;
                maxDate = currentDay - 1;
            } else {
                minDate = currentDay + 1;
            }
        }
        return result;
    }

    private boolean possiblityOfBlloming(int[] bloomDays, int m, int k, int day) {
        int flowerCurrentCount = 0;
        int bouquetCount = 0;
        for (int bloomday : bloomDays) {
            if (bloomday >= day) {
                flowerCurrentCount++;
                if (flowerCurrentCount == k) {
                    bouquetCount++;
                    flowerCurrentCount = 0;
                }
            } else {
                flowerCurrentCount = 0;
            }
            if (bouquetCount == m)
                return true;
        }
        return false;
    }
}
