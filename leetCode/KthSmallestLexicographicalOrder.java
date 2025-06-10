package leetCode;

/**
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order
 * 
 * @author subhrajeetghosh
 */
public class KthSmallestLexicographicalOrder {

    int result = -1, currentCount = 0;

    public int findKthNumber(int n, int k) { // time complexity 0 O(n)
        for (int i = 1; i < 10; i++) {
            rec(i, n, k);
        }
        return result;
    }

    private void rec(int currentNum, int limit, int k) {
        if (limit < currentNum || currentCount > k) {
            return;
        }
        currentCount++;
        if (currentCount == k) {
            result = currentNum;
            return;
        }
        for (int i = 0; i < 10; i++) {
            rec(currentNum * 10 + i, limit, k);
        }
    }

    public int findKthNumber_2ndMethod(int n, int k) { // time complexity - O(log n base 10)
        int currentNum = 1, position = 1;
        while (position < k) {
            int count = countRange(currentNum, n);
            if (position + count <= k) {
                currentNum++;
                position += count;
            } else {
                currentNum *= 10;
                position++;
            }
        }
        return currentNum;
    }

    private int countRange(int currentNum, int limit) {
        long start = currentNum, next = start + 1, count = 0;
        while (start <= limit) {
            count += Math.min(next, limit + 1) - start;
            start *= 10;
            next *= 10;
        }
        return (int) count;
    }
}
