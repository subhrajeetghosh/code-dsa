package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row
 * 
 * @author subhrajeetghosh
 */
public class MinDominoesRotationEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) { // time complexity - O(n)
        int upperResult = 0, bottomResult = 0;
        int[] elementCount = new int[7];
        for (int i = 0; i < tops.length; i++) {
            elementCount[tops[i]]++;
            elementCount[bottoms[i]]++;
        }
        int selectedNum = 0;
        for (int i = 1; i < 7; i++) {
            if (elementCount[i] >= tops.length) {
                selectedNum = i;
            }
        }
        if (selectedNum == 0)
            return -1;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != selectedNum && bottoms[i] != selectedNum) {
                return -1;
            }
            if (tops[i] != selectedNum && bottoms[i] == selectedNum) {
                upperResult++;
            }
            if (bottoms[i] != selectedNum && tops[i] == selectedNum) {
                bottomResult++;
            }
        }
        return Math.min(upperResult, bottomResult);
    }

    // another approch
    public int minDominoRotations_2ndMethod(int[] tops, int[] bottoms) {
        int[] topCount = new int[7];
        int[] bottomCount = new int[7];
        int[] sameCount = new int[7];
        for (int i = 0; i < tops.length; i++) {
            topCount[tops[i]]++;
            bottomCount[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                sameCount[tops[i]]++;
            }
        }
        for (int i = 1; i < 7; i++) {
            if (topCount[i] + bottomCount[i] - sameCount[i] == tops.length) {
                return tops.length - Math.max(topCount[i], bottomCount[i]);
            }
        }
        return -1;
    }

    //another approch
    public int minDominoRotations_3ndMehod(int[] tops, int[] bottoms) { //time complexity - O(n)
        Set<Integer> possibleValue = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] topsCount = new int[7];
        int[] bottomsCount = new int[7];
        for(int i=0; i<tops.length; i++) {
            Set<Integer> currentSet = new HashSet<>(Arrays.asList(tops[i], bottoms[i]));
            possibleValue.retainAll(currentSet);
            if(possibleValue.size() == 0) {
                return -1;
            }
            topsCount[tops[i]]++;
            bottomsCount[bottoms[i]]++;
        }
        int currnetPossibleValue = possibleValue.iterator().next();
        return tops.length - Math.max(topsCount[currnetPossibleValue], bottomsCount[currnetPossibleValue]);
    }
}
