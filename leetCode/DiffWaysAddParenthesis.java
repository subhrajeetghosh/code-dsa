package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses
 * 
 * @author subhrajeetghosh
 */
public class DiffWaysAddParenthesis {
    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) { // time complexity - O(2^n)
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftPart = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightPart = diffWaysToCompute(expression.substring(i + 1));

                for (int leftVal : leftPart) {
                    for (int rightVal : rightPart) {
                        int computedVal = 0;
                        switch (c) {
                            case '+':
                                computedVal = leftVal + rightVal;
                                break;
                            case '-':
                                computedVal = leftVal - rightVal;
                                break;
                            default:
                                computedVal = leftVal * rightVal;
                                break;
                        }
                        result.add(computedVal);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, new ArrayList<>(result));
        return result;
    }
}
