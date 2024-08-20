
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class JavaSHA256 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try (scan) {
            String s = scan.nextLine();
            System.err.println(s);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(s.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                // Convert each byte to hexadecimal
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            // Print the result
            System.out.println(hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            scan.close();
        }
    }
}
