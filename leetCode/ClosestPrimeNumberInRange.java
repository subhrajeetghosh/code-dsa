package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/closest-prime-numbers-in-range
 * 
 * @author subhrajeetghosh
 */
public class ClosestPrimeNumberInRange {
    // Brute force approach
    public int[] closestPrimes(int left, int right) { // time complexity - O(n*m) + O(k)
        List<Integer> primeList = new ArrayList<>();
        if (left == 1)
            left++;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        int currentDist = right - left + 1;
        int[] result = { -1, -1 };
        for (int i = 0; i < primeList.size() - 1; i++) {
            if (Math.abs(primeList.get(i) - primeList.get(i + 1)) < currentDist) {
                currentDist = Math.abs(primeList.get(i) - primeList.get(i + 1));
                result[0] = primeList.get(i);
                result[1] = primeList.get(i + 1);
            }
        }
        return result;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Optimized approach
    public int[] closestPrimes_2ndMethod(int left, int right) { // time complexity - O(nlog(logn))
        int currentDist = right - left + 1;
        boolean[] nonPrime = new boolean[right + 1];
        nonPrime[0] = nonPrime[1] = true;
        for (int i = 2; i * i <= right; i++) {
            for (int j = i * i; j <= right; j += i) {
                nonPrime[j] = true;
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = left; i < nonPrime.length; i++) {
            if (!nonPrime[i]) {
                primeList.add(i);
            }
        }
        int[] result = { -1, -1 };
        for (int i = 0; i < primeList.size() - 1; i++) {
            if (primeList.get(i + 1) - primeList.get(i) < currentDist) {
                currentDist = primeList.get(i + 1) - primeList.get(i);
                result[0] = primeList.get(i);
                result[1] = primeList.get(i + 1);
            }
        }
        return result;
    }

    // More optimized approach
    public int[] closestPrimes_3rdMetehod(int left, int right) { // time complexity - O(nlog(logn))
        int currentDist = right - left + 1;
        boolean[] nonPrime = new boolean[right + 1];
        nonPrime[0] = nonPrime[1] = true;
        for (int i = 2; i * i <= right; i++) {
            for (int j = i * i; j <= right; j += i) {
                nonPrime[j] = true;
            }
        }
        int[] result = { -1, -1 };
        int minDist = Integer.MAX_VALUE, prev = -1;
        for (int i = left; i < nonPrime.length; i++) {
            if (nonPrime[i]) {
                continue;
            }
            if (prev != -1) {
                currentDist = i - prev;
                if (minDist > currentDist) {
                    minDist = currentDist;
                    result[0] = prev;
                    result[1] = i;
                }
            }
            prev = i;
        }
        return result;
    }
}
