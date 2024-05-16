package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction
 * 
 * @author subhrajeetghosh
 */
public class KthSmallestFraction {
    // Bruteforce approch
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double, StringBuilder> map = new HashMap<>();
        List<Double> quetient = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Double qnt = (double) arr[i] / arr[j];
                map.put(qnt, new StringBuilder().append(arr[i]).append(" ").append(arr[j]));
                quetient.add(qnt);
            }
        }
        Collections.sort(quetient);
        StringBuilder sb = map.get(quetient.get(k - 1));
        String[] result = sb.toString().split(" ");
        return new int[] { Integer.parseInt(result[0]), Integer.parseInt(result[1]) };
    }
}
