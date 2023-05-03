/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array
 * 
 * @author Subhrajeet Ghosh
 */
public class SignProductOfArray {
    // this way it will take maximum time and space
    public int arraySign(int[] nums) {
        long M = 1000000007;
        long product = 1;
        for (int i = 0; i < nums.length; i++) {
            product %= M;
            product *= nums[i];
        }
        return product < 0 ? -1 : product == 0 ? 0 : 1;
    }

    public int arraysSign_2ndMethod(int[] nums) {
        int numVal = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            } else {
                numVal *= nums[i] > 0 ? 1 : -1;
            }
        }
        return numVal;
    }

    public int arraysSign_3rdMethod(int[] nums) {
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                return 0;
            else if (nums[i] < 0)
                negativeCount++;
        }
        return negativeCount % 2 == 0 ? 1 : -1;
    }
}
