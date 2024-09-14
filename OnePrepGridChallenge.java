
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */
    public static String gridChallenge(List<String> grid) {
        // Write your code here
        List<List<String>> columns = new ArrayList<>();
        List<List<String>> rows = new ArrayList<>();
        grid.stream().forEach(s -> {
            List<String> row = Stream.of(s.split("")).map(Object::toString).collect(toList());
            Collections.sort(row);
            for (int j = 0; j < row.size(); j++) {
                try {
                    List<String> column = columns.get(j);
                    column.add(row.get(j));
                    columns.set(j, column);
                } catch (IndexOutOfBoundsException e) {
                    List<String> column = new ArrayList<>();
                    column.add(row.get(j));
                    columns.add(column);
                }
            }
            rows.add(row);
        });
        // System.out.println(rows);
        // System.out.println(columns);
        String result = "YES";
        for (int j = 0; j < columns.size(); j++) {
            List<String> column = columns.get(j);
            List<String> sorted = new ArrayList<>(column);
            Collections.sort(sorted);
            if (!column.equals(sorted)) {
                result = "NO";
                break;
            }
        }
        return result;
    }

}

public class OnePrepGridChallenge {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
