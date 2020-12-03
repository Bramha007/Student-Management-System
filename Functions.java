import java.util.Scanner;

public class Functions {

	@SuppressWarnings("resource")
	public static int intro() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to SMS(Student Management System)");
		System.out.println("Tell us who you are :");
		System.out.println("\t1. Student");
		System.out.println("\t2. Admin");
		System.out.println("\t3. Exit");
		int ip = sc.nextInt();
		return ip;
	}
	
	public static int ipStudent() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome Student");
		System.out.println("\t1. Register");
		System.out.println("\t2. View Courses");
		System.out.println("\t3. Apply for a Course");
		int ipStud = sc.nextInt();
		return ipStud;
	}
	
	public static Student registerStudent() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Roll No : ");
		int rollNo = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter your Name : ");
		String name =sc.nextLine();
		System.out.print("Enter your Date of Birth(dd-mm-yyyy): ");
		String dob = sc.nextLine();
		Student student = new Student(rollNo, name, dob);
		return student;
	}
	
	public static int adminIntro() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome Admin");
		System.out.println("\t1. Add a new Course");
		System.out.println("\t2. View Courses");
		System.out.println("\t3. View Students");
		int ipAmin = sc.nextInt();
		return ipAmin;
	}
	
	public static Course addCourse() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter course Id : ");
		int courseId = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter course name : ");
		String courseName = sc.nextLine();
		System.out.print("Enter duration of course : ");
		String duration = sc.nextLine();
		System.out.print("Enter the fees of the course : ");
		double fees = sc.nextDouble();
		Course course = new Course(courseId, courseName, duration, fees);
		return course;
	}
}
