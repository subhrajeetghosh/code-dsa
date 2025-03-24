package leetCode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/count-days-without-meetings
 * 
 * @author subhrajeetghosh
 */
public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) { // time complexity - O(nlogn)
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int currentStart = 1, result = 0;
        for (int[] meeting : meetings) {
            if (currentStart < meeting[0]) {
                result += meeting[0] - currentStart;
            }
            currentStart = Math.max(meeting[1] + 1, currentStart);
        }
        if (currentStart <= days) {
            result += days - currentStart + 1;
        }
        return result;
    }

    public int countDays_2ndMethod(int days, int[][] meetings) { // time complexity - O(n+m)
        int[] arr = new int[days + 2];
        for (int[] meeting : meetings) {
            arr[meeting[0]]++;
            arr[meeting[1] + 1]--;
        }
        int result = 0;
        for (int i = 1; i <= days; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] == 0) {
                result++;
            }
        }
        return result;
    }

    public int countDays_3rdMethod(int days, int[][] meetings) { //time complexity - O(nlogn)
        TreeMap<Integer, Integer> dayMap = new TreeMap<>();
        int previousDay = days, prefixSum = 0, result = 0;
        for(int[] meeting : meetings) {
            previousDay = Math.min(previousDay, meeting[0]);
            dayMap.put(meeting[0], dayMap.getOrDefault(meeting[0], 0) + 1);
            dayMap.put(meeting[1] + 1, dayMap.getOrDefault(meeting[1] + 1, 0) - 1);
        }
        result += previousDay - 1;
        for(int key : dayMap.keySet()) {
            if(prefixSum == 0) {
                result += key - previousDay;
            }
            prefixSum += dayMap.get(key);
            previousDay = key;
        }
        result += days - previousDay + 1;
        return result;
    }
}
