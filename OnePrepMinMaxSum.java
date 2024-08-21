
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        arr.sort((Integer aa, Integer bb) -> aa.compareTo(bb));
        //Collections.sort(arr);
        long min = ((long) arr.get(0)) + ((long) arr.get(1)) + ((long) arr.get(2)) + ((long) arr.get(3));
        long max = ((long) arr.get(4)) + ((long) arr.get(1)) + ((long) arr.get(2)) + ((long) arr.get(3));
        System.out.println(min + " " + max);
    }

}

public class OnePrepMinMaxSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
