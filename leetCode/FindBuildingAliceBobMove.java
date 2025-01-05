package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet
 * 
 * @author subhrajeetghosh
 */
public class FindBuildingAliceBobMove {
    public int[] leftmostBuildingQueries_2ndMethod(int[] heights, int[][] queries) { // time complexity - O(n * k)
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = -1;
            Arrays.sort(queries[i]);
            if (queries[i][0] == queries[i][1] || heights[queries[i][1]] > heights[queries[i][0]]) {
                result[i] = queries[i][1];
                continue;
            }
            for (int j = queries[i][1] + 1; j < heights.length; j++) {
                if (heights[j] > heights[queries[i][0]] && heights[j] > heights[queries[i][1]]) {
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) { //time complexity - O(q+n)
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        @SuppressWarnings("unchecked")
        List<int[]>[] arr = new List[heights.length];
        for(int i=0; i<heights.length; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<queries.length; i++) {
            if(queries[i][0] > queries[i][1]) {
                int tmp = queries[i][0];
                queries[i][0] = queries[i][1];
                queries[i][1] = tmp;
            }
            if(queries[i][0] == queries[i][1] || heights[queries[i][0]] < heights[queries[i][1]]) {
                result[i] = queries[i][1];
                continue;
            }
            arr[queries[i][1]].add(new int[]{Math.max(heights[queries[i][0]], heights[queries[i][1]]), i});
        }
        Stack<Integer> monoStack = new Stack<Integer>();
        int[] nextGreater = new int[heights.length];
        Arrays.fill(nextGreater, -1);
        for(int i=0; i<heights.length; i++) {
            while(!monoStack.isEmpty() && heights[monoStack.peek()] < heights[i]) {
                nextGreater[monoStack.pop()] = i;
            }
            monoStack.push(i);
        }
        for(int i=0; i<heights.length; i++) {
            for(int[] query : arr[i]) {
                int minHeight = query[0];
                int resIndex = query[1];
                int currentIndex = i;
                while(currentIndex != -1 && heights[currentIndex] <= minHeight) {
                    currentIndex = nextGreater[currentIndex];
                }
                result[resIndex] = currentIndex;
            }
        }
        return result;
    }
}
