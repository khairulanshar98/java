
import java.io.*;

public class JavaLoops1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        for (int n = 1; n <= 10; n++) {
            System.out.println("".concat(N + " x ").concat(n + " =").concat(" " + (N * n)));
        }

        bufferedReader.close();
    }
}
