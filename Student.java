
public class Student {
	private int rollNo;
	private String name;
	private String dob;
	public Student(int rollNo, String name, String dob) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", dob=" + dob + "]";
	}
	
}
