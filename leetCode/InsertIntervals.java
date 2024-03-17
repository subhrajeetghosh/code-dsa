package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval
 * 
 * @author subrajeetghosh
 */
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        for (int[] arr : intervals) {
            if (arr[1] < newInterval[0])
                resultList.add(arr);
            else if (arr[0] > newInterval[1]) {
                resultList.add(newInterval);
                newInterval = arr;
            } else {
                newInterval[0] = Math.min(newInterval[0], arr[0]);
                newInterval[1] = Math.max(newInterval[1], arr[1]);
            }
        }
        resultList.add(newInterval);
        return resultList.toArray(new int[resultList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        new InsertIntervals().insert(arr, new int[] { 3, 8 });
    }
}
