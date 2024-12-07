package leetCode;

public class MinLimitBallsInBag {
    // Brute force approch
    public int minimumSize(int[] nums, int maxOperations) { // time complexity - O(n + m*n)
        int maxBall = 0;
        for (int num : nums) {
            maxBall = Math.max(maxBall, num);
        }
        int result = 0;
        for (int i = maxBall; i > 0; i--) {
            if (isPossible(nums, maxOperations, i)) {
                result = i;
            }
        }
        return result;
    }

    public int minimumSize_2ndMethod(int[] nums, int maxOperations) { // time complexity - O(n log m)
        int maxBall = 0;
        for (int num : nums) {
            maxBall = Math.max(maxBall, num);
        }
        int result = maxBall;
        int left = 1, right = maxBall;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, maxOperations, mid)) {
                result = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] nums, int maxOperation, int currentBall) {
        int operation = 0;
        for (int num : nums) {
            operation += (int) Math.ceil((double) num / currentBall) - 1;
            if (operation > maxOperation) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 8, 2 };
        new MinLimitBallsInBag().minimumSize_2ndMethod(arr, 4);
    }
}
