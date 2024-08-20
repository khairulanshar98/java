
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaDuplicateWord {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try (in) {
            String regex = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
            Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            int numSentences = Integer.parseInt(in.nextLine());
            while (numSentences-- > 0) {
                String input = in.nextLine();
                Matcher m = p.matcher(input);
                // Check for subsequences of input that match the compiled pattern
                while (m.find()) {
                    input = input.replaceAll(m.group(0), m.group(1));
                }
                System.out.println(input);
            }
        } finally {
            in.close();
        }
    }
}
