package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/my-calendar-ii
 * 
 * @author subhrajeetghosh
 */
public class CalenderII {

    List<int[]> singleList;
    List<int[]> doubleList;

    public CalenderII() {
        singleList = new ArrayList<>();
        doubleList = new ArrayList<>();
    }

    public boolean book(int start, int end) { // time complexity - O(n)
        for (int[] interval : doubleList) {
            if (start < interval[1] && end > interval[0]) {
                return false;
            }
        }
        for (int[] interval : singleList) {
            if (start < interval[1] && end > interval[0]) {
                int overLapStart = Math.max(start, interval[0]);
                int overLapEnd = Math.min(end, interval[1]);
                doubleList.add(new int[] { overLapStart, overLapEnd });
            }
        }
        singleList.add(new int[] { start, end });
        return true;
    }
}
