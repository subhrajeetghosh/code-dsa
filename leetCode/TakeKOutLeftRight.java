package leetCode;

import java.util.HashMap;
import java.util.Map;

public class TakeKOutLeftRight {
    public int takeCharacters(String s, int k) { // time complexity - O(n)
        if (k == 0)
            return 0;
        Map<Character, Integer> totalCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            totalCount.put(c, totalCount.getOrDefault(c, 0) + 1);
        }
        if (totalCount.size() < 3 || totalCount.get('a') < k || totalCount.get('b') < k || totalCount.get('c') < k) {
            return -1;
        }
        int[] currentCount = new int[3];
        int maxLeftOut = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            currentCount[s.charAt(right) - 'a']++;

            while (currentCount[0] > totalCount.get('a') - k
                    || currentCount[1] > totalCount.get('b') - k
                    || currentCount[2] > totalCount.get('c') - k) {
                currentCount[s.charAt(left++) - 'a']--;
            }

            maxLeftOut = Math.max(maxLeftOut, right - left + 1);
        }
        return s.length() - maxLeftOut;
    }

    public static void main(String[] args) {
        new TakeKOutLeftRight().takeCharacters("aabaaaacaabc", 2);
    }
}
