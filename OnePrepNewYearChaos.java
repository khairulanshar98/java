
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    static void swap(List<Integer> arr, int i, int j) {
        Integer ii = arr.get(i);
        Integer jj = arr.get(j);
        arr.set(i, jj);
        arr.set(j, ii);
    }

    static void bubbleSort(List<Integer> q) {
        for (int i = 0; i < q.size(); i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < q.size() - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                int aj = (int) q.get(j);
                int aj_1 = (int) q.get(j + 1);
                if (aj > aj_1) {
                    swap(q, j, j + 1);
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int c = 0;
        for (int i = q.size() - 1; i > 0; i--) {
            int ii = (int) q.get(i);
            if (ii != i + 1) {
                int ii_1 = (int) q.get(i - 1);
                if (ii_1 == i + 1) {
                    c += 1;
                    swap(q, i, i - 1);
                } else {
                    int ii_2 = (int) q.get(i - 2);
                    if (ii_2 == i + 1) {
                        c += 2;
                        swap(q, i - 2, i - 1);
                        swap(q, i - 1, i);
                    } else {
                        System.out.println("Too chaotic");
                        return;
                    }
                }
            }
        }
        System.out.println(c);
    }

}

public class OnePrepNewYearChaos {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
