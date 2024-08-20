import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.PriorityQueue;
import java.util.Iterator;
/*
 * Create the Student and Priorities classes here.
 */
 class Studentx implements Comparable {
    private int id;
    private String name;
    private double cgpa;
    public Studentx (int id, String name, double cgpa) {
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
        Studentx p = (Studentx) o;
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
    private PriorityQueue<Studentx> pq;
    public Priorities() {
        this.pq = new PriorityQueue<>();
    }
    
    public List<Studentx> getStudents(List<String> events){
        List<Studentx> result = new ArrayList<>();
        for(String event : events){
            String[] s = event.replaceAll("\\s+$", "").split(" ");
            String op = s[0];
            if(op.equals("ENTER")) {
                String name = s[1];
                double cgpa = Double.parseDouble(s[2]);
                int id = Integer.parseInt(s[3]);
                Studentx stu = new Studentx(id,name,cgpa);
                pq.add(stu);
                //System.out.println(op+" "+name+" "+cgpa+" "+id);
            } else {
                //System.out.println(op);
                pq.poll();  
            }
        }
        Iterator iter = pq.iterator();
        while(iter.hasNext()){
            result.add(pq.poll());
        }
        return result;
    }

}


public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Studentx> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Studentx st: students) {
                System.out.println(st.getName());
            }
        }
    }
}