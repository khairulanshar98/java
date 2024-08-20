
import java.util.*;

class Student {
}

class Rockstar {
}

class Hacker {
}

public class JavaInstanceof {

    static String count(ArrayList<Object> mylist) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < mylist.size(); i++) {
            Object element = mylist.get(i);
            if (element.getClass().getName().equalsIgnoreCase("Student")) {
                a++;
            }
            if (element.getClass().getName().equalsIgnoreCase("Rockstar")) {
                b++;
            }
            if (element.getClass().getName().equalsIgnoreCase("Hacker")) {
                c++;
            }
        }
        String ret = Integer.toString(a) + " " + Integer.toString(b) + " " + Integer.toString(c);
        return ret;
    }
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (scan) {
            ArrayList<Object> mylist = new ArrayList<>();
            int t = scan.nextInt();
            for (int i = 0; i < t; i++) {
                String s = scan.next();
                if (s.equals("Student")) {
                    mylist.add(new Student());
                }
                if (s.equals("Rockstar")) {
                    mylist.add(new Rockstar());
                }
                if (s.equals("Hacker")) {
                    mylist.add(new Hacker());
                }
            }
            System.out.println(count(mylist));
        } finally {
            scan.close();
        }
    }
}
