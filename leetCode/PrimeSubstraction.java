package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PrimeSubstraction {
    public boolean primeSubOperation(int[] nums) { //time complexity - 
        List<Integer> primes = generatePrimesUpTo(1000);
    
        int previous = 0;
        for (int current : nums) {
            int difference = current - previous;
            int primeToSubtract = largestPrimeLessThan(primes, difference);
    
            if (primeToSubtract != -1) {
                current -= primeToSubtract;
            }
    
            if (current <= previous) {
                return false;
            }
    
            previous = current;
        }
        return true;
    }
    
    private List<Integer> generatePrimesUpTo(int limit) {
        boolean[] isNotPrime = new boolean[limit + 1];
        for (int i = 2; i * i <= limit; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
    
    private int largestPrimeLessThan(List<Integer> primes, int max) {
        int result = -1;
        int left = 0, right = primes.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (primes.get(mid) < max) {
                result = primes.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
