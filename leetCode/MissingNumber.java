package leetCode;

/**
 * https://leetcode.com/problems/missing-number/
 * 
 * @author subhrajeetghosh
 */
public class MissingNumber {
    public int missingNumber(int[] nums) { // time complexity - O(n), space complexity - O(n)
        int[] copyArr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            copyArr[nums[i]]++;
        }
        for (int i = 1; i < copyArr.length; i++) {
            if (copyArr[i] == 0)
                return i;
        }
        return 0;
    }

    public int missingNumber_2ndMethod(int[] nums) { // time complexity - O(n), space complexity - O(1)
        long sum = 0;
        long indexSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            indexSum += i + 1;
        }
        return (int) (indexSum - sum);
    }
}
