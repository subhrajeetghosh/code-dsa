package leetCode;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row
 * 
 * @author subhrajeetghosh
 */
public class MinDominoesRotationEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) { // time complexity - O(n)
        int upperResult = 0, bottomResult = 0;
        int[] elementCount = new int[7];
        for (int i = 0; i < tops.length; i++) {
            elementCount[tops[i]]++;
            elementCount[bottoms[i]]++;
        }
        int selectedNum = 0;
        for (int i = 1; i < 7; i++) {
            if (elementCount[i] >= tops.length) {
                selectedNum = i;
            }
        }
        if (selectedNum == 0)
            return -1;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != selectedNum && bottoms[i] != selectedNum) {
                return -1;
            }
            if (tops[i] != selectedNum && bottoms[i] == selectedNum) {
                upperResult++;
            }
            if (bottoms[i] != selectedNum && tops[i] == selectedNum) {
                bottomResult++;
            }
        }
        return Math.min(upperResult, bottomResult);
    }
}
