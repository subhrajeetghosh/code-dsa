package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/design-a-food-rating-system
 * 
 * @author Subhrajeet Ghosh
 */

class FoodRatings {

    Map<String, TreeSet<FoodInfo>> cuisineMap;
    Map<String, FoodInfo> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap = new HashMap<>();
        foodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            FoodInfo foodInfo = new FoodInfo(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], foodInfo);
            if (!cuisineMap.containsKey(foodInfo.cuisine)) {
                cuisineMap.put(foodInfo.cuisine,
                        new TreeSet<>((a, b) -> a.rating == b.rating ? a.name.compareTo(b.name) : a.rating - b.rating));
            }
            cuisineMap.get(foodInfo.cuisine).add(foodInfo);
        }

    }

    public void changeRating(String food, int newRating) {
        FoodInfo currentFood = foodMap.get(food);
        TreeSet<FoodInfo> foodCuisine = cuisineMap.get(currentFood.cuisine);
        foodCuisine.remove(currentFood);
        currentFood.rating = newRating;
        foodCuisine.add(currentFood);
    }

    public String highestRated(String cuisine) {
        TreeSet<FoodInfo> foodCuisine = cuisineMap.get(cuisine);
        return foodCuisine.first().name;

    }
}

class FoodInfo {
    String name;
    String cuisine;
    int rating;

    FoodInfo(String name, String cuisine, int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}
