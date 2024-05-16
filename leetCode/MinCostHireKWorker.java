package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-cost-to-hire-k-workers
 * 
 * @author subhrajeetghosh
 */
public class MinCostHireKWorker {
    double result = Double.MAX_VALUE;

    // Bruteforce Approch
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) { // time complexity - O(n log n )
        List<MinCostHireWorker> listOfWorker = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            listOfWorker.add(new MinCostHireWorker(quality[i], (double) wage[i] / quality[i]));
        }
        Collections.sort(listOfWorker);
        for (int i = 0; i < quality.length - k + 1; i++) {
            checkMinCostToHire(listOfWorker, k - 1, listOfWorker.get(i).quality * listOfWorker.get(i).proportion, i + 1,
                    listOfWorker.get(i).proportion);

        }
        return result;
    }

    private void checkMinCostToHire(List<MinCostHireWorker> listOfWorker, int k, double currentSum, int currentIndex,
            double currentProp) {
        if (k == 0) {
            result = Math.min(result, currentSum);
            return;
        }
        if (currentIndex >= listOfWorker.size() || currentSum >= result) {
            return;
        }
        checkMinCostToHire(listOfWorker, k, currentSum, currentIndex + 1, currentProp);
        currentSum += listOfWorker.get(currentIndex).quality * currentProp;
        checkMinCostToHire(listOfWorker, k - 1, currentSum, currentIndex + 1, currentProp);
        currentSum -= listOfWorker.get(currentIndex).quality * currentProp;
    }

    private class MinCostHireWorker implements Comparable<MinCostHireWorker> {

        int quality;
        double proportion;

        public MinCostHireWorker(int quality, double proportion) {
            this.quality = quality;
            this.proportion = proportion;
        }

        @Override
        public int compareTo(MinCostHireWorker o) {
            return Double.compare(o.proportion, this.proportion);
        }
    }

    // Optimized approch
    public double mincostToHireWorkers_2ndMethod(int[] quality, int[] wage, int k) { // time complexity - O(n log n)
        double[][] arr = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            arr[i] = new double[] { (double) quality[i], (double) wage[i] / quality[i] };
        }
        Arrays.sort(arr, (a, b) -> Double.compare(a[1], b[1]));
        double result = Double.MAX_VALUE;
        double qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (double[] ar : arr) {
            qsum += ar[0];
            pq.add(ar[0]);
            if (pq.size() > k) {
                qsum -= pq.poll();
            }
            if (pq.size() == k) {
                result = Math.min(result, ar[1] * qsum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 5 };
        int[] arr2 = { 70, 50, 30 };
        MinCostHireKWorker sf = new MinCostHireKWorker();
        double result = sf.mincostToHireWorkers(arr1, arr2, 2);
        System.out.println(result); // Expected output is 105.0
    }
}