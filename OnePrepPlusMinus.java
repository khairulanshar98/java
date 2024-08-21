
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        Double b = Double.parseDouble("1") / arr.size();
        List<Double> arr1 = IntStream.range(0, 3).mapToObj(i -> Double.valueOf("0")).collect(toList());
        arr.stream().forEach(i -> {
            int x = 0;
            if (i < 0) {
                x = 1;
            } else if (i == 0) {
                x = 2;
            }
            Double a = arr1.get(x) + b;
            arr1.set(x, a);
        });
        arr1.stream().forEach(d -> {
            System.out.println(String.format("%.6f", d));
        });
    }

}

public class OnePrepPlusMinus {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
