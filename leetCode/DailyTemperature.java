package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * @author subhrajeetghosh
 */
public class DailyTemperature {
    // bruteforce approch
    public int[] dailyTemperatures_2ndMethod(int[] temperatures) { // time complexity - O(n^2)
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            boolean isChecked = false;
            int count = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                count++;
                if (temperatures[i] < temperatures[j]) {
                    isChecked = true;
                    break;
                }
            }
            result[i] = isChecked ? count : 0;
        }
        return result;
    }

    // 2nd Method
    public int[] dailyTemperatures(int[] temp) { // time complexity - O(n)
        int[] result = new int[temp.length];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = temp.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && temp[st.peek()] <= temp[i])
                st.pop();
            if (!st.isEmpty())
                result[i] = st.peek() - i;
            st.push(i);
        }
        return result;
    }
}
