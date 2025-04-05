package miscellaneous;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * find the different usage of {@link List} stream method
 * 
 * @author subhrajeetghosh
 */

public class ListStreamUsage {

    public static Optional<DeferredCalculationExecution> getDeferedData(String asd) {
        List<DeferredCalculationExecution> deferredCalcExeList = Arrays.asList(
                new DeferredCalculationExecution("68", "test2"),
                new DeferredCalculationExecution("56", "tes2"), new DeferredCalculationExecution("57", "tes2"));
        for (DeferredCalculationExecution deferredCalculationExecution : deferredCalcExeList) {
            if (deferredCalculationExecution.getOrderKeyId().equals(asd)) {
                return Optional.of(deferredCalculationExecution);
            }
        }
        return Optional.empty();
    }

    public static <T> java.util.function.Predicate<T> distinctByKey(
            java.util.function.Function<? super T, Object> keyExtractor) {
        Set<Object> seen = new HashSet<>();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static void main(String[] args) {
        List<DeferredCalculationExecution> deferredCalcExeList = Arrays.asList(
                new DeferredCalculationExecution("56", "test2"),
                new DeferredCalculationExecution("56", "tes2"), new DeferredCalculationExecution("57", "tes2"));
        // Populate the list with DeferredCalculationExecution objects

        // Find Distinct Object based on one Filter
        List<DeferredCalculationExecution> distinctObjects = deferredCalcExeList.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(DeferredCalculationExecution::getOrderKeyId,
                                obj -> obj,
                                (obj1, obj2) -> obj1),
                        map -> new ArrayList<>(map.values())));

        List<DeferredCalculationExecution> deferList = deferredCalcExeList.stream().filter(
                distinctByKey(DeferredCalculationExecution::getOrderKeyId)).limit(4).collect(Collectors.toList());
        List<String> orderKey = Arrays.asList("56", "57");

        List<DeferredCalculationExecution> filterDataFromOptional = orderKey.stream()
                .map(orderHeaderId -> getDeferedData(orderHeaderId)).filter(
                        Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());

        System.out.println(distinctObjects);
        System.out.println(deferList);
        System.out.println(filterDataFromOptional);
    }
}

class DeferredCalculationExecution {
    private String orderKeyId;
    private String name;

    public String getOrderKeyId() {
        return orderKeyId;
    }

    public String getName() {
        return name;
    }

    public void setOrderKeyId(String orderKeyId) {
        this.orderKeyId = orderKeyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeferredCalculationExecution(String a, String b) {
        this.orderKeyId = a;
        this.name = b;
    }
}