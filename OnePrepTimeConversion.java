
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        // Write your code here
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        final DateTimeFormatter dateTimeFormatter12 = DateTimeFormatter.ofPattern("hh:mm:ssa");
        return LocalTime.parse(s, dateTimeFormatter12).format(dateTimeFormatter);
    }

}

public class OnePrepTimeConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
