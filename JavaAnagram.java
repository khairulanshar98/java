
import java.util.Scanner;

public class JavaAnagram {

    private static final Scanner scan = new Scanner(System.in);

    static boolean isAnagram(String a, String b) {
        // Complete the function
        char[] ca = a.toLowerCase().toCharArray();
        char[] cb = b.toLowerCase().toCharArray();
        java.util.Arrays.sort(ca);
        java.util.Arrays.sort(cb);
        return java.util.Arrays.equals(ca, cb);
    }

    public static void main(String[] args) {
        try (scan) {
            String a = scan.next();
            String b = scan.next();
            boolean ret = isAnagram(a, b);
            System.out.println((ret) ? "Anagrams" : "Not Anagrams");
        } finally {
            scan.close();
        }
    }
}
