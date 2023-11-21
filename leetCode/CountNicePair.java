package leetCode;

/**
 * https://leetcode.com/problems/count-nice-pairs-in-an-array
 * 
 * @author subhrajeetghosh
 */

public class CountNicePair {

    //BruteForce Approch
    public int countNicePairs(int[] nums) {
        int[] revVal = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            revVal[i] = getRevVal(nums[i]);
        }
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]+revVal[j] == nums[j]+revVal[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getRevVal(int num) {
        return Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
    }

    public static void main(String[] args) {
        new CountNicePair().countNicePairs(new int[] { 42, 11, 10, 97 });
    }
}
