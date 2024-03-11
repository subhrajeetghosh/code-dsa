package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-all-people-with-secret
 * 
 * @author subhrajeetghosh
 */
public class FindPeopleWithSecret {
    //Bruteforce Approch
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
        
        return null;
    }
}
