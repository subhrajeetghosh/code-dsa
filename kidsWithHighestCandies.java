import java.util.ArrayList;
import java.util.List;


public class kidsWithHighestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> listOfData = new ArrayList<>();
        int maxCandies = 0;
        for(int i=0; i<candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        for(int i=0; i<candies.length; i++) {
            if(candies[i]+extraCandies >= maxCandies) {
                listOfData.add(true);
            }
            else {
                listOfData.add(false);
            }
        }
        return listOfData;
    }
}
