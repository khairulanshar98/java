
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Node implements Comparable {

    int index;
    List<Integer> adjacents = new ArrayList<Integer>();
    int distance = -1;

    Node(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Object o) {
        Node p = (Node) o;
        return distance - p.distance;
    }
}

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */
    private static final int EDGE_DISTANCE = 6;

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        List<Integer> result = new ArrayList();
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            Node node = new Node(i);
            nodes.add(node);
        }
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            int u = edge.get(0);
            int v = edge.get(1);
            nodes.get(u).adjacents.add(v);
            nodes.get(v).adjacents.add(u);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        nodes.get(s).distance = 0;
        queue.offer(nodes.get(s));
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            for (int adjacent : head.adjacents) {
                Node node = nodes.get(adjacent);
                int distance = (int) node.distance;
                if (distance < 0) {
                    node.distance = head.distance + EDGE_DISTANCE;
                    queue.offer(nodes.get(adjacent));
                }
            }
        }
        nodes.stream().forEach(node -> {
            int index = (int) node.index;
            if (index != s && index > 0) {
                result.add(node.distance);
            }
        });
        return result;
    }

}

public class MockBfs {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                        + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
