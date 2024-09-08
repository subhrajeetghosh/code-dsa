package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii
 * 
 * @author subhrajeetghosh
 */

public class MinNumberPushKeyWord {
    public int minimumPushes(String word) { // time complexity - O(n log n)
        int[] freqCount = new int[26];
        for (char c : word.toCharArray()) {
            freqCount[c - 'a']++;
        }

        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freqCount[i] > 0) {
                pairList.add(new Pair((char) ('a' + i), freqCount[i]));
            }
        }

        pairList.sort((a, b) -> b.freq - a.freq);

        int priorityNum = 8, tappingCount = 1, result = 0;
        while (!pairList.isEmpty()) {
            int size = Math.min(priorityNum, pairList.size());
            for (int i = 0; i < size; i++) {
                result += tappingCount * pairList.get(0).freq;
                pairList.remove(0);
            }
            tappingCount++;
        }
        return result;
    }

    class Pair {
        char c;
        int freq;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
