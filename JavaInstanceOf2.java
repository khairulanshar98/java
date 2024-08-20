
import java.util.*;

public class JavaInstanceOf2 {

    static Iterator func(ArrayList<Object> mylist) {
        Iterator it = mylist.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            if (element instanceof String && element.equals("###"))//Hints: use instanceof operator
            {
                break;
            }
        }
        return it;

    }
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (sc) {
            ArrayList<Object> mylist = new ArrayList<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                mylist.add(sc.nextInt());
            }

            mylist.add("###");
            for (int i = 0; i < m; i++) {
                mylist.add(sc.next());
            }

            Iterator it = func(mylist);
            while (it.hasNext()) {
                Object element = it.next();
                System.out.println((String) element);
            }
        } finally {
            sc.close();
        }
    }
}
