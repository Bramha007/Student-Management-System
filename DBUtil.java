import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getDbConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Nitish@123");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
