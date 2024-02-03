package leetCode;

public class PartitionArrayMaxSum {
    // Bruteforce Approch
    public int maxSumAfterPartitioning_2ndMethod(int[] arr, int k) { //time complexity - O(k^(n/k))
        return maxSumPart(arr, k, 0);                          // decision tree has k level and process n/k data at each level 
    }

    public int maxSumPart_2ndMethod(int[] arr, int k, int index) {
        if (index >= arr.length)
            return 0;
        int currentMaxPointer = arr[index];
        int maxSum = arr[index];
        int currentK = k;
        while (currentK > 0 && index < arr.length) {
            currentK--;
            if (index > 0) {
                if (arr[index] > currentMaxPointer) {
                    currentMaxPointer = arr[index];
                }
            }
            int currentMaxSum = (currentMaxPointer * (k - currentK) + maxSumPart(arr, k, index + 1));
            maxSum = Math.max(currentMaxSum, maxSum);
            index++;
        }
        return maxSum;
    }

    // Memorization
    Integer[][] memo;

    public int maxSumAfterPartitioning(int[] arr, int k) {  //time complexity - O(n * k)
        memo = new Integer[k + 1][arr.length + 1];
        return maxSumPart(arr, k, 0);
    }

    public int maxSumPart(int[] arr, int k, int index) {
        if (index >= arr.length)
            return 0;
        if (memo[k][index] != null)
            return memo[k][index];
        int currentMaxPointer = arr[index];
        int maxSum = arr[index];
        int currentK = k;
        int staticIndex = index;
        while (currentK > 0 && index < arr.length) {
            currentK--;
            if (index > 0) {
                if (arr[index] > currentMaxPointer) {
                    currentMaxPointer = arr[index];
                }
            }
            int currentMaxSum = (currentMaxPointer * (k - currentK) + maxSumPart(arr, k, index + 1));
            maxSum = Math.max(currentMaxSum, maxSum);
            index++;
        }
        return memo[k][staticIndex] = maxSum;
    }
}
