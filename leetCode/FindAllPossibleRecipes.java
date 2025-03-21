package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies
 * 
 * @author subhrajeetghosh
 */
public class FindAllPossibleRecipes {
    public List<String> findAllRecipes(String[] recipes,
            List<List<String>> ingredients, String[] supplies) { // time complexity - O(n * m)
        List<String> result = new ArrayList<>();
        Set<String> suppliesSet = new HashSet<>();
        for (String spl : supplies) {
            suppliesSet.add(spl);
        }
        boolean isChange = true;
        while (isChange) {
            isChange = false;
            for (int i = 0; i < recipes.length; i++) {
                if (!suppliesSet.contains(recipes[i])) {
                    boolean hadIngredients = true;
                    for (String ing : ingredients.get(i)) {
                        if (!suppliesSet.contains(ing)) {
                            hadIngredients = false;
                            break;
                        }
                    }
                    if (hadIngredients) {
                        suppliesSet.add(recipes[i]);
                        result.add(recipes[i]);
                        isChange = true;
                    }
                }
            }
        }
        return result;
    }

    public List<String> findAllRecipes_2ndMethod(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<String>();
        Map<String, Boolean> suppliesSet = new HashMap<String, Boolean>();
        Map<String, Integer> recipeIndex = new HashMap<String, Integer>();
        for (String spl : supplies) {
            suppliesSet.put(spl, true);
        }
        for (int i = 0; i < recipes.length; i++) {
            recipeIndex.put(recipes[i], i);
        }
        for (String recipe : recipes) {
            if (isSuppliesFound(recipe, recipeIndex, suppliesSet, ingredients, new HashSet<>())) {
                result.add(recipe);
            }
        }
        return result;
    }

    private boolean isSuppliesFound(String item, Map<String, Integer> recipeIndex, Map<String, Boolean> suppliesSet,
            List<List<String>> ingredients, Set<String> visited) { // time complexity - O(n + m + s)
        if (suppliesSet.containsKey(item)) {
            return suppliesSet.get(item);
        }
        if (!recipeIndex.containsKey(item) || visited.contains(item)) {
            suppliesSet.put(item, false);
            return false;
        }
        visited.add(item);
        for (String ingredient : ingredients.get(recipeIndex.get(item))) {
            if (!isSuppliesFound(ingredient, recipeIndex, suppliesSet, ingredients, visited)) {
                return false;
            }
        }
        suppliesSet.put(item, true);
        return true;
    }
}
