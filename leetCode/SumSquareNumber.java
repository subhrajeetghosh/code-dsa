package leetCode;

/**
 * https://leetcode.com/problems/sum-of-square-numbers
 * 
 * @author subhrajeetghosh
 */
public class SumSquareNumber {
    public boolean judgeSquareSum(int c) { //time complexity - O(log c)
        long left = 0, right = (long) Math.sqrt(c);
        while(left<=right) {
            long current = left * left + right * right;
            if(current < c) {
                left++;
            } else if(current > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
