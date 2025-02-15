package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/editorial
 * 
 * @author subhrajeetghosh
 */
class ProductOfNumbers { // time complexity - O(n)
    List<Integer> numbers;

    public ProductOfNumbers() {
        numbers = new ArrayList<>();
        numbers.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            numbers = new ArrayList<>();
            numbers.add(1);
        } else {
            numbers.add(numbers.get(numbers.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k > numbers.size() - 1) {
            return 0;
        }
        return numbers.get(numbers.size() - 1) / numbers.get(numbers.size() - k - 1);
    }
}