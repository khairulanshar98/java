
import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        } else {
            return p2.score - p1.score;
        }
    }
}

class Player {

    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class JavaComparator {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            int n = scan.nextInt();
            Player[] players = new Player[n];
            Checker checker = new Checker();

            for (int i = 0; i < n; i++) {
                players[i] = new Player(scan.next(), scan.nextInt());
            }
            Arrays.sort(players, checker);
            for (Player player : players) {
                System.out.printf("%s %s\n", player.name, player.score);
            }
        } finally {
            scan.close();
        }
    }
}
