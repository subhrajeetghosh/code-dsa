import java.util.ArrayList;
import java.util.List;

public class TestClass {

    private void sortLinesForRateCardLineType(List<OrderLine> orderLines) {
        orderLines.sort((o1, o2) -> {
            String[] parts1 = o1.getDisplayLineNumber().split("\\.");
            String[] parts2 = o2.getDisplayLineNumber().split("\\.");
    
            int minLength = Math.min(parts1.length, parts2.length);
            for (int i = 0; i < minLength; i++) {
                boolean isNumeric1 = parts1[i].matches("\\d+");
                boolean isNumeric2 = parts2[i].matches("\\d+");
    
                if (isNumeric1 && isNumeric2) {
                    int result = Integer.compare(Integer.parseInt(parts1[i]), Integer.parseInt(parts2[i]));
                    if (result != 0) {
                        return result;
                    }
                } else if (isNumeric1 || isNumeric2) {
                    return isNumeric1 ? -1 : 1;
                } else {
                    int result = parts1[i].compareTo(parts2[i]);
                    if (result != 0) {
                        return result;
                    }
                }
            }
            return Integer.compare(parts1.length, parts2.length);
        });
    }    

    public static void main(String[] args) {
        List<OrderLine> withCharacterOrderLine = new ArrayList<>();
        withCharacterOrderLine.add(new OrderLine("1.1...2.1.B91444"));
        withCharacterOrderLine.add(new OrderLine("1.1...1.1.B91444"));
        withCharacterOrderLine.add(new OrderLine("1.1.1.B91444"));


        TestClass sorter = new TestClass();
        sorter.sortLinesForRateCardLineType(withCharacterOrderLine);

        // Output the results
        withCharacterOrderLine.forEach(line -> System.out.println(line.getDisplayLineNumber()));
    }
}

class OrderLine {
    private String displayLineNumber;

    public OrderLine(String displayLineNumber) {
        this.displayLineNumber = displayLineNumber;
    }

    public String getDisplayLineNumber() {
        return displayLineNumber;
    }

    public void setDisplayLineNumber(String displayLineNumber) {
        this.displayLineNumber = displayLineNumber;
    }

    private void sortLinesForRateCardLineType(List<OrderLine> orderLines) {
        orderLines.sort((o1, o2) -> {
          String[] parts1 = o1.getDisplayLineNumber().split("\\.");
          String[] parts2 = o2.getDisplayLineNumber().split("\\.");
    
          int length = Math.min(parts1.length, parts2.length);
          for (int i = 0; i < length; i++) {
            boolean isNumeric1 = parts1[i].matches("\\d+");
            boolean isNumeric2 = parts2[i].matches("\\d+");
    
            if (isNumeric1 && isNumeric2) {
              int result = Integer.compare(Integer.parseInt(parts1[i]), Integer.parseInt(parts2[i]));
              if (result != 0) {
                return result;
              }
            } else if (isNumeric1) {
              return -1;
            } else if (isNumeric2) {
              return 1;
            } else {
              int result = parts1[i].compareTo(parts2[i]);
              if (result != 0) {
                return result;
              }
            }
          }
          return Integer.compare(parts1.length, parts2.length);
        });
      }
}
