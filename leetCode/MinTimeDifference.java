package leetCode;

import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-difference
 * 
 * @author subhrajeetghosh
 */
public class MinTimeDifference {
    public int findMinDifference(List<String> timePoints) { //time complexity - O(n log n)
        Collections.sort(timePoints);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            String[] prevArr = timePoints.get(i - 1).split(":");
            String[] arr = timePoints.get(i).split(":");
            int previousTime = (Integer.parseInt(prevArr[0]) * 60) + Integer.parseInt(prevArr[1]);
            int currentTime = (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
            result = Math.min(result, currentTime - previousTime);
        }
        String[] firstArr = timePoints.get(0).split(":");
        String[] lastArr = timePoints.get(timePoints.size() - 1).split(":");
        int firstArrTime = ((Integer.parseInt(firstArr[0]) * 60) + Integer.parseInt(firstArr[1])) + (24 * 60);
        int lastArrTime = (Integer.parseInt(lastArr[0]) * 60) + Integer.parseInt(lastArr[1]);
        return Math.min(result, firstArrTime - lastArrTime);
    }


}
