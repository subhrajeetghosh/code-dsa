package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-days-without-meetings
 * 
 * @author subhrajeetghosh
 */
public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) { //time complexity - O(nlogn)
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
}
