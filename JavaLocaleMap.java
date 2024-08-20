
import java.text.*;
import java.util.*;

public class JavaLocaleMap {

    private static final String[] currency = new String[]{"US", "India", "China", "France"};
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (scanner) {
            double payment = scanner.nextDouble();
            Map<String, Locale> localeMap = new HashMap<>();
            localeMap.put("US", Locale.US);
            localeMap.put("China", Locale.CHINA);
            localeMap.put("France", Locale.FRANCE);
            localeMap.put("India", new Locale("en", "IN"));
            for (String curr : currency) {
                System.out.println(
                        curr + ": "
                        + NumberFormat.getCurrencyInstance(localeMap.get(curr)).format(payment));
            }
        } finally {
            scanner.close();
        }
    }
}
