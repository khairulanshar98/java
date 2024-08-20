
import java.util.*;

public class JavaLoops2 {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] argh) {
        try (in) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int n = in.nextInt();
                String result = "";
                for (int l = 0; l < n; l++) {
                    int power = (int) Math.pow(2, l);
                    a += power * b;
                    result = result.concat(a + " ");
                }
                System.out.println(result.trim());
            }
        } finally {
            in.close();
        }
    }
}
