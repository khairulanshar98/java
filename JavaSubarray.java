
import java.util.*;
import java.util.stream.*;

public class JavaSubarray {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            int n = scan.nextInt();
            List<Integer> result = new ArrayList<>();
            /*int[] arr = new int[n];
            for(int i = 0; i < arr.length; i++){
                arr[i] = scan.nextInt();
            }
            for(int length = 1; length <= arr.length; length++) {
                for(int i = 0; i <= arr.length - length; i++) {
                    int[] subarr = Arrays.copyOfRange(arr, i, i + length);
                    //System.out.println(length+":"+Arrays.stream(subarr).boxed().collect(Collectors.toList()));
                    int sum = Arrays.stream(subarr).reduce(0, Integer::sum);
                    if (sum<0) result.add(sum);
                }
            }*/
            List<Integer> arr = new ArrayList<>();
            while (scan.hasNextInt()) {
                arr.add(scan.nextInt());
            }
            IntStream.range(1, n + 1).forEach(length -> {
                IntStream.range(0, n + 1 - length).forEach(i -> {
                    List<Integer> copyArr = arr.subList(i, i + length);
                    //System.out.println(length+":"+copyArr);
                    int sum = copyArr.stream().reduce(0, Integer::sum);
                    if (sum < 0) {
                        result.add(sum);
                    }
                });
            });
            System.out.println(result.size());
        } finally {
            scan.close();
        }
    }
}
