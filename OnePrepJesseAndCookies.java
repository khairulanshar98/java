
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> sweetnesses = new PriorityQueue<>(A);
        // System.err.println(sweetnesses);
        int operationNum = 0;
        while (sweetnesses.peek() < k && sweetnesses.size() >= 2) {
            int leastSweetness = sweetnesses.poll();
            int secondLeastSweetness = sweetnesses.poll();
            sweetnesses.add(leastSweetness + 2 * secondLeastSweetness);
            // System.err.println(sweetnesses);
            operationNum++;
        }
        return (sweetnesses.peek() >= k) ? operationNum : -1;
    }

}

public class OnePrepJesseAndCookies {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
