package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/task-scheduler/
 * 
 * @author subhrajeetghosh
 */

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) { // time complexity - O(n) as the sorting array length 26
        int[] charArray = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            charArray[tasks[i] - 'A']++;
        }
        Arrays.sort(charArray);
        int maxLength = charArray[25] - 1;
        int iddle = maxLength * n;
        for (int i = 24; i >= 0; i--) {
            iddle -= Math.min(maxLength, charArray[i]);
        }
        return iddle > 0 ? iddle + tasks.length : tasks.length;
    }
}
