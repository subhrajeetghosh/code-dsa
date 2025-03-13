package leetCode;

/**
 * https://leetcode.com/problems/zero-array-transformation-ii/
 * 
 * @author subhrajeetghosh
 */
public class ZeroArrayTransformationII {
    public int minZeroArray(int[] nums, int[][] queries) { // time complexity - O(m * (n+k))
        int result = 0;
        for (int[] query : queries) {
            result++;
            for (int i = query[0]; i <= query[1]; i++) {
                nums[i] -= Math.min(nums[i], query[2]);
            }
            boolean isAllZero = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    isAllZero = false;
                    break;
                }
            }
            if (isAllZero) {
                return result;
            }
        }
        return -1;
    }

    public int minZeroArray_2ndMethod(int[] nums, int[][] queries) { // time complexity - O(n logn)
        if (!currentIndexingZero(nums, queries, queries.length)) {
            return -1;
        }
        int left = 0, right = queries.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (currentIndexingZero(nums, queries, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean currentIndexingZero(int[] nums, int[][] queries, int k) {
        int[] diff = new int[nums.length + 1];
        for (int i = 0; i < k; i++) {
            diff[queries[i][0]] += queries[i][2];
            diff[queries[i][1] + 1] -= queries[i][2];
        }
        for (int i = 0; i < nums.length; i++) {
            diff[i + 1] += diff[i];
            if (diff[i] < nums[i])
                return false;
        }
        return true;
    }

    public int minZeroArray_3rdMethod(int[] nums, int[][] queries) { //time complexity - O(n + m)
        int sum = 0, k = 0;;
        int[] diff = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            while(sum + diff[i] < nums[i]) {
                k++;
                if(k > queries.length) return -1;
                int left = queries[k-1][0], right = queries[k-1][1], val = queries[k-1][2];
                if(right >= i) {
                    diff[Math.max(left, i)] += val;
                    diff[right+1] -= val;
                }
            }
            sum += diff[i];
        }
        return k;
    }
}
