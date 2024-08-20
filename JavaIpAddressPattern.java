
import java.util.Scanner;

public class JavaIpAddressPattern {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            while (scan.hasNext()) {
                String IP = scan.next();
                System.out.println(IP.matches(new MyRegex().pattern));
            }
        } finally {
            scan.close();
        }
    }
}

//Write your code here
class MyRegex {

    private final String p = "(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|\\d{1,2})";
    public final String pattern = "^" + "(" + p + "\\.){3}" + p;
}
