
import java.util.Scanner;

class UsernameValidator {

    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "[a-zA-Z][a-zA-Z0-9_]{7,29}";
    /*
    [a-zA-Z] Matches any letter at the beggining
    [a-zA-Z0-9_] Matches any letter, digit or underscore. Equivalent to \w.
    {7,29} From 8 to 30, but counting here the beggining letter.
     */
}

public class JavaUsernamePattern {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            int n = Integer.parseInt(scan.nextLine());
            while (n-- != 0) {
                String userName = scan.nextLine();
                if (userName.matches(UsernameValidator.regularExpression)) {
                    System.out.println("Valid");
                } else {
                    System.out.println("Invalid");
                }
            }
        } finally {
            scan.close();
        }
    }
}
