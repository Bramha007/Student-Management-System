import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBOps {

	public static void insertStudentRecord(Student student) {
		Connection con = null;
		try {
			con = DBUtil.getDbConnection();
			String sql = "SELECT * FROM student WHERE rollno = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getRollNo());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() != false) {
				System.out.println("User with that Roll Number already Esxits");
				return;
			} else {
				String sql1 = "INSERT INTO student(rollno, name, dob)" + "VALUES(?, ?, ?)";
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				pstmt1.setInt(1, student.getRollNo());
				pstmt1.setString(2, student.getName());
				pstmt1.setString(3, student.getDob());
				pstmt1.executeUpdate();
				System.out.println("Registered Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fetchCourses() {
		Connection con = null;
		Statement stmt = null;
		try {
			con = DBUtil.getDbConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM course";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() == false) {
				System.out.println("No Courses to Display");
			} else {
				String heading = String.format("%12s|%12s|%12s|%12s", "Course Id", "Course Name", "Duration", "Fees");
				System.out.println(heading);
				do {
					int courseId = rs.getInt("courseid");
					String courseName = rs.getString("coursename");
					String duration = rs.getString("duration");
					double fees = rs.getDouble("fees");
					String courseDetail = String.format("%12d|%12s|%12s|%12.2f", courseId, courseName, duration, fees);
					System.out.println(courseDetail);
				} while (rs.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void applyCourse() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose the Course you want to apply : ");
		int courseIdIp = sc.nextInt();
		sc.nextLine();
		Connection con = null;
		try {
			con = DBUtil.getDbConnection();
			String sql1 = "SELECT * FROM course where courseid = ?";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, courseIdIp);
			ResultSet rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				System.out.println(
						"Course Id : " + rs1.getInt("courseid") + "| Course Name : " + rs1.getString("coursename")
								+ "| Duration : " + rs1.getString("duration") + "| Fees : " + rs1.getDouble("fees"));
			}
			System.out.print("Enter you ROll Number : ");
			int rollNo = sc.nextInt();
			String sql2 = "SELECT * FROM student WHERE rollno = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, rollNo);
			ResultSet rs2 = pstmt2.executeQuery();
			if (rs2.next()) {
				System.out.println("Applying......");
				int rollNum = rs2.getInt("rollno");
				String name = rs2.getString("name");
				String dob = rs2.getString("dob");
				String sql3 = "INSERT INTO student_course VALUES (?, ?, ?, ?)";
				PreparedStatement pstmt3 = con.prepareStatement(sql3);
				pstmt3.setInt(1, rollNum);
				pstmt3.setString(2, name);
				pstmt3.setString(3, dob);
				pstmt3.setInt(4, courseIdIp);
				pstmt3.executeUpdate();
				System.out.println("Applied Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addCourse(Course course) {
		Connection con = null;
		try {
			con = DBUtil.getDbConnection();
			String sql = "SELECT * FROM course WHERE courseid = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course.getCourseId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() != false) {
				System.out.println("Course Already Exists");
				return;
			} else {
				String sql1 = "INSERT INTO course(courseid, coursename, duration, fees)" + "VALUES(?, ?, ?, ?)";
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				pstmt1.setInt(1, course.getCourseId());
				pstmt1.setString(2, course.getCourseName());
				pstmt1.setString(3, course.getDuration());
				pstmt1.setDouble(4, course.getFees());
				pstmt1.executeUpdate();
				System.out.println("Course added");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fetchAllStudentsEnrolledAndRegistered() {
		Connection con = null;
		Statement stmt = null;
		Statement stmt2 = null;
		try {
			con = DBUtil.getDbConnection();
			stmt = con.createStatement();

			stmt2 = con.createStatement();
			String sql_en = "SELECT * FROM student_course";
			ResultSet rs1 = stmt.executeQuery(sql_en);
			System.out.println("Students Enrolled in Course/Courses : ");
			String heading1 = String.format("%12s|%12s|%12s|%12s", "Roll number", "Student name", "Date Of Birth",
					"Course Id");
			System.out.println(heading1);
			while (rs1.next()) {
				int rollNo = rs1.getInt("student_rollno");
				String name = rs1.getString("student_name");
				String dob = rs1.getString("student_dob");
				int courseId = rs1.getInt("course_courseid");
				String op1 = String.format("%12d|%12s|%12s|%12d", rollNo, name, dob, courseId);
				System.out.println(op1);
			}
			System.out.println();
			System.out.println("ALl students who Registered");
			String sql_reg = "SELECT * FROM student";
			ResultSet rs2 = stmt2.executeQuery(sql_reg);
			String heading2 = String.format("%12s|%12s|%12s", "Roll number", "Student name", "Date Of Birth");
			System.out.println(heading2);
			while (rs2.next()) {
				int rollNo = rs2.getInt("rollno");
				String name = rs2.getString("name");
				String dob = rs2.getString("dob");
				String op2 = String.format("%12d|%12s|%12s", rollNo, name, dob);
				System.out.println(op2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
