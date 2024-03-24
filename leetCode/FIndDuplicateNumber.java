package leetCode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * @author subhrajeetghosh
 */
public class FIndDuplicateNumber {
    public int findDuplicate(int[] nums) { // time compleity - O(n)
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
