
import java.util.*;

public class JavaGameArray {

    private static final Scanner scan = new Scanner(System.in);

    public static boolean canWin(int leap, int[] game, int index) {
        // Return true if you can win the game; otherwise, return false.
        if (index < 0 || game[index] == 1) {
            return false;
        } else if (index + 1 > game.length - 1 || index + leap > game.length - 1) {
            return true;
        }
        game[index] = 1;
        return canWin(leap, game, index - 1)
                || canWin(leap, game, index + 1)
                || canWin(leap, game, index + leap);
    }

    public static void main(String[] args) {
        try (scan) {
            int q = scan.nextInt();
            while (q-- > 0) {
                int n = scan.nextInt();
                int leap = scan.nextInt();

                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }

                System.out.println((canWin(leap, game, 0)) ? "YES" : "NO");
            }
        } finally {
            scan.close();
        }
    }
}
