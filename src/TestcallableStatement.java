import java.sql.*;
import java.util.Scanner;

public class TestcallableStatement {

	public static void main(String[] args) {
		Connection con=null;
		int id;
		String name;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id.....");
		id=scanner.nextInt();
		
		System.out.println("Enter the name......");
		name=scanner.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
			CallableStatement cstmt=con.prepareCall("{call insertRecord(?,?)}");
			cstmt.setInt(1, id);
			cstmt.setString(2, name);
			int count = cstmt.executeUpdate();
			System.out.println("Sucess..........."+count);
		}catch(Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}

}
