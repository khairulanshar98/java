
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    private static final List<String> original = Stream.of("abcdefghijklmnopqrstuvwxyz".split("")).map(Object::toString).collect(toList());

    public static String caesarCipher(String s, int k) {
        // Write your code here
        int kk = k % 26;
        List<String> left = original.subList(0, kk);
        List<String> right = original.subList(kk, original.size());
        List<String> newList = Stream.concat(right.stream(), left.stream())
                .collect(toList());
        List<String> ss = Stream.of(s.split("")).map(Object::toString).collect(toList());
        return ss.stream().map(sss -> {
            String a = sss;
            int index = original.indexOf(sss.toLowerCase());
            if (index >= 0) {
                a = newList.get(index);
                if (!sss.toLowerCase().equals(sss)) {
                    a = a.toUpperCase();
                }
            }
            return a;
        }).collect(joining(""));
    }

}

public class OnePrepCaesarCipher {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
