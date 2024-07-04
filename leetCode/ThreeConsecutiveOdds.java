package leetCode;

/**
 * https://leetcode.com/problems/three-consecutive-odds
 * 
 * @author subhrajeetghosh
 */

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) { //time complexity - O(n)
        int consOdds = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                consOdds++;
            } else {
                consOdds = 0;
            }
            if (consOdds == 3) {
                return true;
            }
        }
        return false;
    }
}
