package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/rabbits-in-forest
 * 
 * @author subhrajeetghosh
 */
public class RabbitsInForest {
    public int numRabbits(int[] answers) { // time complexity - O(n log n)
        Arrays.sort(answers);
        int result = 0, sameCount = 1, currentNum = answers[0];
        for (int i = 1; i < answers.length; i++) {
            if (answers[i] == 0) {
                result++;
                continue;
            }
            if (currentNum == answers[i]) {
                sameCount++;
            } else {
                result += answers[i - 1] + 1;
                currentNum = answers[i];
                sameCount = 1;
            }
            if (sameCount > currentNum + 1) {
                result += currentNum + 1;
                sameCount = 1;
            }
            if (i == answers.length - 1) {
                result += answers[i] + 1;
            }
        }
        return result;
    }

    public int numRabbits_2ndMethod(int[] answers) { // time complexity - O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < answers.length; i++) {
            int currentRabits = map.getOrDefault(answers[i], 0);
            if (currentRabits == 0) {
                result += answers[i] + 1;
                map.put(answers[i], answers[i]);
            } else {
                map.put(answers[i], map.get(answers[i]) - 1);
            }
        }
        return result;
    }
}
