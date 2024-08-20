import java.util.*;
import java.math.BigDecimal;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

class Checker implements Comparator<Student>{
    
    @Override
    public int compare(Student p1, Student p2){
        if (p1.getCgpa()==p2.getCgpa()) {
            return p1.getFname().compareTo(p2.getFname());
        } else {
            BigDecimal b1 = new BigDecimal(p1.getCgpa());
            BigDecimal b2 = new BigDecimal(p2.getCgpa());
            return b2.compareTo(b1);
        }
    }
}

//Complete the code
public class JavaSort
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        studentList.sort(new Checker());
        for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



