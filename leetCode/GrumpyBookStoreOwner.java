package leetCode;

/**
 * https://leetcode.com/problems/grumpy-bookstore-owner
 * 
 * @author subhrajeetghosh
 */

public class GrumpyBookStoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) { // time complexity - O(n)
        int left = 0, right = 0, currentRes = 0, generalResult = 0;
        for (; right < minutes; right++) {
            if (grumpy[right] == 1) {
                currentRes += customers[right];
            } else {
                generalResult += customers[right];
            }
        }
        int result = currentRes;
        for (; right < customers.length; right++) {
            if (grumpy[left] == 1) {
                currentRes -= customers[left];
            }
            if (grumpy[right] == 1) {
                currentRes += customers[right];
            } else {
                generalResult += customers[right];
            }
            result = Math.max(result, currentRes);
            left++;
        }
        return generalResult + result;
    }
}
