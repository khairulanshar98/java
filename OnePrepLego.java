
import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */
    private static final long MOD = 1000000007;

    public static int legoBlocks(int n, int m) {
        // Write your code here
        if (n == 1) {
            return m < 5 ? 1 : 0;
        }
        long[] permutation = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            if (i < 5) {
                permutation[i] = 1;
                for (int j = i - 1; j >= 1; j--) {
                    permutation[i] += permutation[j];
                    permutation[i] %= MOD;
                }
            } else {
                permutation[i] = permutation[i - 1] + permutation[i - 2] + permutation[i - 3] + permutation[i - 4];
                permutation[i] %= MOD;
            }
        }
        //
        long[] total = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            total[i] = 1;
            for (int j = 1; j <= n; j++) {
                total[i] *= permutation[i];
                total[i] %= MOD;
            }
        }
        //
        long[] good = new long[m + 1];
        good[1] = 1;
        long[] bad = new long[m + 1];
        bad[1] = 0;
        for (int i = 2; i <= m; i++) {
            bad[i] = 0;
            for (int j = 1; j < i; j++) {
                bad[i] += good[j] * total[i - j];
                bad[i] %= MOD;
            }
            good[i] = (total[i] - bad[i] + MOD) % MOD;
        }
        return (int) good[m];

    }

}

public class OnePrepLego {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

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
