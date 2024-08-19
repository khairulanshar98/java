import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaLocaleMap {
    
    private static String[] currency = new String[] {"US", "India", "China", "France"};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        Map<String, Locale> localeMap = new HashMap<>();
        localeMap.put("US", Locale.US);
        localeMap.put("China", Locale.CHINA);
        localeMap.put("France", Locale.FRANCE);
        localeMap.put("India", new Locale("en", "IN"));
        for(String curr: currency) {
                System.out.println(
                    curr+": " + 
                    NumberFormat.getCurrencyInstance(localeMap.get(curr)).format(payment));
        }
    }
}