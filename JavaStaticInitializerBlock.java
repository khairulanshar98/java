
import java.util.*;

public class JavaStaticInitializerBlock {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try (scanner) {
            int B = scanner.nextInt();
            int H = scanner.nextInt();
            if (B > 0 && H > 0) {
                int area = B * H;
                System.out.print(area);
            } else {
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            scanner.close();
        }
    }//end of main
}//end of class
