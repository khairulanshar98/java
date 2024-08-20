
import java.util.Scanner;

public class JavaOutputFormatting {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (sc) {
            System.out.println("================================");
            for (int i = 0; i < 3; i++) {
                String s1 = sc.next();
                int x = sc.nextInt();
                //Complete this line
                System.out.printf("%-15s%03d%n", s1, x);
            }
            System.out.println("================================");
        } finally {
            sc.close();
        }
    }
}
