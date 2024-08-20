
import java.util.*;

public class JavaMap1 {

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        try (s) {
            int t = s.nextInt();
            String[] pair_left = new String[t];
            String[] pair_right = new String[t];

            for (int i = 0; i < t; i++) {
                pair_left[i] = s.next();
                pair_right[i] = s.next();
            }
            //Write your code here
            Map<String, Integer> names = new HashMap<>();
            for (int i = 0; i < t; i++) {
                String key = pair_left[i].concat(",").concat(pair_right[i]);
                Integer value = 0;
                try {
                    value = names.get(key);
                } catch (Exception e) {
                }
                names.put(key, value);
                System.out.println(names.size());
            }
        } finally {
            s.close();
        }
    }
}
