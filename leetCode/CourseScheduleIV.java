package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule-iv/
 * 
 * @author subhrajeetghosh
 */
public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int[] arr : prerequisites) {
            if (!map.containsKey(arr[1])) {
                map.put(arr[1], new HashSet<>());
            }
            map.get(arr[1]).add(arr[0]);
        }
        List<Boolean> result = new ArrayList<Boolean>();
        for (int[] arr : queries) {
            int currentKey = arr[1];
            Set<Integer> currentSet = new HashSet<>(currentKey);
            boolean currentAnswer = false;
            for (int key : currentSet) {
                while (map.containsKey(key)) {
                    Set<Integer> currentPreReq = map.get(key);
                    if (currentPreReq.contains(arr[0])) {
                        currentAnswer = true;
                        break;
                    }
                    currentSet = new HashSet<>(currentPreReq);
                }
            }
            result.add(currentAnswer);
        }
        return result;
    }
}
