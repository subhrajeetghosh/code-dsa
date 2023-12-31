package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/destination-city/
 * 
 * @author subhrajeetghosh
 */
public class DestinationCity {
    // initial approch
    public String destCity(List<List<String>> paths) {
        Set<String> city1 = new HashSet<String>();
        Set<String> city2 = new HashSet<String>();
        for (List<String> path : paths) {
            city1.add(path.get(0));
            city2.add(path.get(1));
        }
        Iterator<String> setIterator = city2.iterator();
        while (setIterator.hasNext()) {
            if (!city1.contains(setIterator.next())) {
                setIterator.remove();
            }
        }
        return city2.iterator().next();
    }

    // more optimized approch
    public String destCity_2ndMethod(List<List<String>> paths) {
        Set<String> city1 = new HashSet<String>();
        Set<String> city2 = new HashSet<String>();
        for (List<String> path : paths) {
            city1.add(path.get(0));
            city2.add(path.get(1));
        }
        for (String city : city2) {
            if (!city1.contains(city)) {
                return city;
            }
        }
        return "";
    }

    // another approch unsing hashmap
    public String destCity_3rdMethod(List<List<String>> paths) {
        Map<String, String> destinationCity = new HashMap<String, String>();
        for (List<String> list : paths) {
            destinationCity.put(list.get(0), list.get(1));
        }
        String currentDestination = paths.get(0).get(1);
        while (!destinationCity.containsKey(currentDestination)) {
            currentDestination = destinationCity.get(currentDestination);
        }
        return currentDestination;
    }
}
