
import java.util.Scanner;
import java.util.regex.*;

public class JavaPatternCompile {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try (in) {
            int testCases = Integer.parseInt(in.nextLine());
            while (testCases > 0) {
                try {
                    String pattern = in.nextLine();
                    Pattern.compile(pattern);
                    System.out.println("Valid");
                } catch (Exception e) {
                    System.out.println("Invalid");
                }
                testCases--;
            }
        } finally {
            in.close();
        }
    }
}
