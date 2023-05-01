/**
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 * 
 * @author Subhrajeet Ghosh
 */

public class AverageSalaryExcludingMinMax {
    public double average(int[] salary) {
        double total = 0;
        int minSalary = Integer.MIN_VALUE;
        int maxSalary = Integer.MAX_VALUE;
        for (int i = 0; i < salary.length; i++) {
            minSalary = Math.min(minSalary, salary[i]);
            maxSalary = Math.max(maxSalary, salary[i]);
            total += salary[i];
        }
        total -= (minSalary + maxSalary);
        return total / (salary.length - 2);
    }
}