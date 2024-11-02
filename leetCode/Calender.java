package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MyCalendar {
    List<int[]> listOfData;

    public MyCalendar() {
        listOfData = new ArrayList<>();
    }

    public boolean book(int start, int end) { // time complexity O(n^2)
        for (int[] booking : listOfData) {
            int existingStart = booking[0];
            int existingEnd = booking[1];
            if (start < existingEnd && existingStart < end) {
                return false;
            }
        }
        listOfData.add(new int[] { start, end });
        return true;
    }

    // Using TreeMap
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public boolean book_treeMap(int start, int end) { // time complexity - (log n)
        Integer prevKey = map.floorKey(start);

        Integer nextKey = map.ceilingKey(start);

        if (prevKey != null && map.get(prevKey) > start)
            return false;

        if (nextKey != null && nextKey < end)
            return false;

        map.put(start, end);
        return true;
    }

}