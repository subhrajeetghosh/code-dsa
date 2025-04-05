package miscellaneous;
/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range
 * 
 * @author subhrajeetghosh
 */
public class BitAndMerge {

    //Brute force approch
    public int rangeBitwiseAnd_2ndMethod(int left, int right) {
        int result = left;
        for(int i=left+1; i<right; i++) {
            result &= i;
        }
        return result;
    }

    //optimized approch doing reverse & will reduce step take an example like 5, 12
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left) {
            right = right & right - 1;
        }
        return right & left;
    }
}
