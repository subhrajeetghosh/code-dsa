package lintcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/920/
 * 
 * @author subhrajeetghosh
 */
public class MeetingRoom {
    // time complexity - O(n*m) as n -> list count, m -> time point
    // space complexity - O(m) -> m is the time point
    public boolean canAttendMeetings(List<Interval> intervals) {
        Set<Integer> set = new HashSet<Integer>();
        for (Interval interval : intervals) {
            for (int i = interval.start; i <= interval.end; i++) {
                if (!set.add(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // different bruteforce approch
    public boolean canAttendMeetings_2ndMethod(List<Interval> intervals) { // time complexity - O(n^2)
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (isOverlaped(intervals.get(i), intervals.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isOverlaped(Interval i1, Interval i2) {
        return Math.min(i1.end, i2.end) > Math.max(i1.start, i2.start);
    }

    // optimized approch
    public boolean canAttendMeetings_3rdMethod(List<Interval> intervals) { // time complexity - O(n)
        if (intervals == null || intervals.size() <= 1)
            return true;
        intervals.sort(Comparator.comparing(i -> i.start));
        int end = -1;
        for (int i = 0; i < intervals.size(); i++) {
            if (end > intervals.get(i).start) {
                return false;
            }
            end = intervals.get(i).end;
        }
        return true;
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}