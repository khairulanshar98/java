
import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int palindromeIndex(String s) {
        // Write your code here
        int length = s.length();
        int middle = (int) (length / 2);
        for (int i = 0; i <= middle; i++) {
            int l = length - 1 - i;
            char front = s.charAt(i);
            char end = s.charAt(l);
            if (front != end) {
                char front_i_1 = s.charAt(i + 1);
                char front_i_2 = s.charAt(i + 2);
                char end_i_2 = s.charAt(l - 1);
                if (front_i_1 == end && front_i_2 == end_i_2) {
                    return i;
                }
                if (front == end_i_2) {
                    return l;
                }
            }
        }
        return -1;
    }

}

public class MockPalindromeIndex {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
