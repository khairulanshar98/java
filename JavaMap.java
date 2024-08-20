
import java.util.*;

public class JavaMap {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] argh) {
        try (in) {
            int n = in.nextInt();
            in.nextLine();
            Map<String, Integer> pbook = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String name = in.nextLine();
                int phone = in.nextInt();
                pbook.put(name, phone);
                in.nextLine();
            }
            while (in.hasNext()) {
                String s = in.nextLine();
                try {
                    int phone = pbook.get(s);
                    System.out.println(s.concat("=").concat(phone + ""));
                } catch (Exception e) {
                    System.out.println("Not found");
                }
            }
        } finally {
            in.close();
        }
    }
}
