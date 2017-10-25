import java.sql.*;

public class transactionManagement {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
			
			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			
			stmt.executeUpdate("insert into employee values(123,'justin',1234343,'sales')");
			stmt.executeUpdate("insert into employee values(223,'andrew',5435435,'tester')");
			
			con.commit();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
