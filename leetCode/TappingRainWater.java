package leetCode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * @author Subhrajeet Ghosh
 */
public class TappingRainWater {
    public int trap(int[] height) {  //time complexity - O(n+n)
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int leftMaxPointer = 0;
        int rightMaxPointer = 0;
        for (int i = 0; i < height.length; i++) {
            leftMaxPointer = Math.max(leftMaxPointer, height[i]);
            leftMax[i] = leftMaxPointer;
            rightMaxPointer = Math.max(rightMaxPointer, height[height.length - 1 - i]);
            rightMax[height.length - 1 - i] = rightMaxPointer;
        }
        int tappingCount = 0;
        for (int i = 0; i < height.length; i++) {
            tappingCount += Math.min(leftMax[i], rightMax[i]) - height[i] > 0
                    ? Math.min(leftMax[i], rightMax[i]) - height[i]
                    : 0;
        }
        return tappingCount;
    }
}
