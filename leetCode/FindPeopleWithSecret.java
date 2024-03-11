package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-all-people-with-secret
 * 
 * @author subhrajeetghosh
 */
public class FindPeopleWithSecret {
    // Bruteforce Approch
    public List<Integer> findAllPeople_2ndMethod(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparing(row -> row[2]));
        Set<Integer> resultSet = new HashSet<>();
        resultSet.add(0);
        resultSet.add(firstPerson);
        int currentTime = -1;
        int index = 0;
        for (int[] arr : meetings) {
            if (resultSet.contains(arr[0]) || resultSet.contains(arr[1])) {
                resultSet.add(arr[0]);
                resultSet.add(arr[1]);
                if (currentTime == arr[2]) {
                    int currentIndex = index;
                    while (currentIndex >= 0 && meetings[currentIndex][2] == currentTime) {
                        if (resultSet.contains(meetings[index - 1][0]) || resultSet.contains(meetings[index - 1][1])) {
                            resultSet.add(meetings[index - 1][0]);
                            resultSet.add(meetings[index - 1][1]);
                        }
                        currentIndex--;
                    }
                }
            }
            currentTime = arr[2];
            index++;
        }
        return new ArrayList<>(resultSet);
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<PersonTime>> map = new HashMap<>();
        for (int[] meeting : meetings) {
            map.putIfAbsent(meeting[0], new ArrayList<>());
            map.putIfAbsent(meeting[1], new ArrayList<>());
            map.get(meeting[0]).add(new PersonTime(meeting[1], meeting[2]));
            map.get(meeting[1]).add(new PersonTime(meeting[0], meeting[2]));
        }
        Set<Integer> result = new HashSet<>();
        PriorityQueue<PersonTime> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new PersonTime(0, 0));
        pq.add(new PersonTime(firstPerson, 0));
        while (!pq.isEmpty()) {
            PersonTime currentPersonTime = pq.poll();
            result.add(currentPersonTime.person);
            for(PersonTime pt : map.get(currentPersonTime.person)) {
                if(currentPersonTime.time <= pt.time) {
                    pq.add(new PersonTime(pt.person, pt.time));
                }
                map.remove(currentPersonTime.person);
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * InnerFindPeopleWithSecret
     */
    public class PersonTime {
        int person;
        int time;

        public PersonTime(int person, int time) {
            this.person = person;
            this.time = time;
        }
    }
}
