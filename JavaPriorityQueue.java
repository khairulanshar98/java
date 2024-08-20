
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Create the Student and Priorities classes here.
 */
class Student implements Comparable {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Object o) {
        Student p = (Student) o;
        if (this.cgpa == p.getCGPA()) {
            return this.name.compareTo(p.getName());
        } else {
            BigDecimal b1 = new BigDecimal(this.cgpa);
            BigDecimal b2 = new BigDecimal(p.getCGPA());
            return b2.compareTo(b1);
        }
    }
}

class Priorities {

    private PriorityQueue<Student> pq;

    public Priorities() {
        this.pq = new PriorityQueue<>();
    }

    public List<Student> getStudents(List<String> events) {
        List<Student> result = new ArrayList<>();
        for (String event : events) {
            String[] s = event.replaceAll("\\s+$", "").split(" ");
            String op = s[0];
            if (op.equals("ENTER")) {
                String name = s[1];
                double cgpa = Double.parseDouble(s[2]);
                int id = Integer.parseInt(s[3]);
                Student stu = new Student(id, name, cgpa);
                pq.add(stu);
                //System.out.println(op+" "+name+" "+cgpa+" "+id);
            } else {
                //System.out.println(op);
                pq.poll();
            }
        }
        Iterator iter = pq.iterator();
        while (iter.hasNext()) {
            result.add(pq.poll());
        }
        return result;
    }

}

public class JavaPriorityQueue {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        try (scan) {
            int totalEvents = Integer.parseInt(scan.nextLine());
            List<String> events = new ArrayList<>();

            while (totalEvents-- != 0) {
                String event = scan.nextLine();
                events.add(event);
            }

            List<Student> students = priorities.getStudents(events);

            if (students.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                for (Student st : students) {
                    System.out.println(st.getName());
                }
            }
        } finally {
            scan.close();
        }
    }
}
