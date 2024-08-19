import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaTagPattern {
    private static String reg = "<([^<>]+)>([^<>]+)</\\1>";
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		Pattern pattern = Pattern.compile(reg);
        while(testCases-- >0){
			String line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
			if (!matcher.find()) {
                System.out.println("None");
            } else {
                System.out.println(matcher.group(2));
                while (matcher.find()) {
                    System.out.println(matcher.group(2));
                }
            }
		}
	}
}



