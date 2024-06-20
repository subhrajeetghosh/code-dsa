package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MagneticForceTwoBall {
    // Bruteforce approch
    public int maxDistance_2ndMethod(int[] position, int m) { // time complexity - O(n) * O(n log n)
        int firstPoint = Integer.MAX_VALUE;
        int lastPoint = Integer.MIN_VALUE;
        Set<Integer> positionSet = new HashSet<>();
        for (int i : position) {
            positionSet.add(i);
            firstPoint = Math.min(firstPoint, i);
            lastPoint = Math.max(lastPoint, i);
        }
        int left = 0, right = lastPoint;
        int result = 0;
        while (left <= right) {
            int currentMid = (left + right) / 2;
            if (isPossible(positionSet, firstPoint, lastPoint, currentMid, m)) {
                result = currentMid;
                left = currentMid + 1;
            } else {
                right = currentMid - 1;
            }
        }
        return result;
    }

    private boolean isPossible(Set<Integer> positionSet, int firstPoint, int lastPoint, int currentForce, int m) {
        int currentM = 1;
        while (firstPoint <= lastPoint) {
            if (positionSet.contains(firstPoint + currentForce)) {
                firstPoint = firstPoint + currentForce;
                currentM++;
            } else {
                firstPoint++;
            }
            if (currentM == m)
                return true;
        }
        return false;
    }

    //Optimized approch
    public int maxDistance(int[] position, int m) { // time complexity - O(nlog n + O(n logD)
        Arrays.sort(position);
        int left = 0, right = position[position.length - 1] - position[0];
        int result = 0;
        while (left <= right) {
            int currentMid = (left + right) / 2;
            if (isPossible(position, m, currentMid)) {
                result = currentMid;
                left = currentMid + 1;
            } else {
                right = currentMid - 1;
            }
        }
        return result;
    }

    private boolean isPossible(int[] position, int m, int force) {
        int currentPosition = position[0];
        int currentBall = 1;
        for (int i = 1; i < position.length; i++) {
            if (currentPosition + force <= position[i]) {
                currentBall++;
                currentPosition = position[i];
            }
            if (m == currentBall)
                return true;
        }
        return false;
    }
}
