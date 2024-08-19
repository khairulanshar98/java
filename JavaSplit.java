import java.io.*;
import java.util.*;

public class JavaSplit {
    private static String delimeter = "[\\s!,?._'@]+";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        if (s.trim().length() == 0) {
            System.out.println(0);            
        } else {
            String[] arrs = s.trim().split(delimeter);
            System.out.println(arrs.length);
            for (String a :arrs)
                System.out.println(a);
        }
        scan.close();
    }
}

