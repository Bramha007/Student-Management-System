import java.util.Scanner;

public class SMS {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ip = 0;
		do {
			ip = Functions.intro();
			if(ip==1) {
				int ipStud = Functions.ipStudent();
				if(ipStud == 1) {
					Student student = Functions.registerStudent();
					DBOps.insertStudentRecord(student);
				}else if(ipStud == 2) {
					DBOps.fetchCourses();
				}
				else if(ipStud == 3) {
					DBOps.fetchCourses();
					DBOps.applyCourse();
				}
			}else if(ip == 2) {
				int ipAdmin = Functions.adminIntro();
				if(ipAdmin == 1) {
					Course course = Functions.addCourse();
					System.out.println(course.toString());
					DBOps.addCourse(course);
				}else if(ipAdmin == 2) {
					DBOps.fetchCourses();
				}
				else if(ipAdmin == 3) {
					DBOps.fetchAllStudentsEnrolledAndRegistered();
				}
			}
		}while(ip != 3);
		sc.close();
	}
}
