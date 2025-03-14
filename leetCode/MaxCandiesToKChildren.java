package leetCode;

/**
 * https://leetcode.com/problems/maximum-candies-allocated-to-k-children
 * 
 * @author subhrajeetghosh
 */
public class MaxCandiesToKChildren {

    // Bruteforce
    public int maximumCandies(int[] candies, long k) { // time complexity - O(n * max(candies[i]))
        int result = 0, currentTarget = 1;
        while (isDistributionPossible(candies, k, currentTarget)) {
            result = currentTarget;
            currentTarget++;
        }
        return result;
    }

    private boolean isDistributionPossible(int[] candies, long k, int target) {
        long count = 0;
        for (int candy : candies) {
            count += candy / target;
            if (count >= k)
                return true;
        }
        return false;
    }

    public int maximumCandies_2ndMethod(int[] candies, long k) { // time complexity - O(n * log(max(candies[i])))
        int left = 1, right = 0, result = 0;
        for (int candy : candies) {
            right = Math.max(right, candy);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isDistributionPossible(candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}
