package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/course-schedule-iv/
 * 
 * @author subhrajeetghosh
 */
public class CourseScheduleIV {
    //Bruteforce Approch
    public List<Boolean> checkIfPrerequisite_2ndMethod(int numCourses, int[][] prerequisites, int[][] queries) { //time complexity - O(p + q * n!)
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] arr : prerequisites) {
            if (!map.containsKey(arr[1])) {
                map.put(arr[1], new ArrayList<>());
            }
            map.get(arr[1]).add(arr[0]);
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPreReq_2ndMethod(map, query[1], query[0]));
        }
        return result;
    }

    private boolean isPreReq_2ndMethod(Map<Integer, List<Integer>> map, int mainCourse, int preReq) {
        if (!map.containsKey(mainCourse)) {
            return false;
        }
        for (Integer num : map.get(mainCourse)) {
            if (num == preReq) {
                return true;
            } else if (isPreReq_2ndMethod(map, num, preReq)) {
                return true;
            }
        }
        return false;
    }

    //Optimized memorization
    Map<String, Boolean> memo;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) { //time complexity - O(p + q * (n^2))
        memo = new HashMap<String, Boolean>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] arr : prerequisites) {
            if (!map.containsKey(arr[1])) {
                map.put(arr[1], new ArrayList<>());
            }
            map.get(arr[1]).add(arr[0]);
        }
        List<Boolean> result = new ArrayList<>();
        for(int[] query : queries) {
            result.add(isPreReq(map, query[1], query[0]));
        }
        return result;
    }

    private boolean isPreReq(Map<Integer, List<Integer>> map, int mainCourse, int preReq) {
        String key = mainCourse + "_" + preReq;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(!map.containsKey(mainCourse)) {
            return false;
        }
        for(Integer num : map.get(mainCourse)) {
            if(num == preReq || isPreReq(map, num, preReq)) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;      
    }
}
