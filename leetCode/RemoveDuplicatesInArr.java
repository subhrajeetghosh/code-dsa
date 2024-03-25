package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array
 * 
 * @author subhrajeetghosh
 */
public class RemoveDuplicatesInArr {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[index] *= -1;
            }
        }
        return result;
    }
}
