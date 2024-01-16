package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1
 * 
 * @author subhrajeetghosh
 */
public class RandomizedSet {
    Set<Integer> set;
    List<Integer> list;

    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (set.add(val)) {
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (set.remove(val)) {
            list.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomIndex = new Random().nextInt(list.size());
        return list.get(randomIndex);
    }
}
