package leetCode;

/**
 * https://leetcode.com/problems/type-of-triangle
 * 
 * @author subhrajeetghosh
 */
public class TypeOfTriangle {
    public String triangleType(int[] nums) { // time complexity - O(1)
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if ((nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2])
                && (nums[0] < nums[1] + nums[2] && nums[1] < nums[0] + nums[2] && nums[2] < nums[0] + nums[1])) {
            return "isosceles";
        } else if (nums[0] < nums[1] + nums[2] && nums[1] < nums[0] + nums[2] && nums[2] < nums[0] + nums[1]) {
            return "scalene";
        }
        return "none";
    }
}
