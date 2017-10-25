import java.sql.*;

public class TestDataBaseMetadata {

	public static void main(String[] args) {

		Connection con=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");

		DatabaseMetaData rsmd=con.getMetaData();
		
		System.out.println("Driver Name--->"+rsmd.getDriverName());
		System.out.println("Driver version---->"+rsmd.getDriverVersion());
		System.out.println("User name---->"+rsmd.getUserName());
		System.out.println("DataBase Product Name--->"+rsmd.getDatabaseProductName());
		System.out.println("DataBase product Version---->"+rsmd.getDatabaseProductVersion());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
