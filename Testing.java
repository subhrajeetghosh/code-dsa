import java.time.Duration;
import java.time.Instant;

public class Testing {
    public static void main(String[] args) {
        String time = "";
        Instant retryDateTime = Instant.now().minus(Duration.ofHours(Long.parseLong(time)));
        System.out.println(retryDateTime);
    }
}