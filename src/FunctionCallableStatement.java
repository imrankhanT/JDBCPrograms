import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class FunctionCallableStatement {

	public static void main(String[] args) {
		
			Connection con=null;
			int n1,n2;
	
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the number1.....");
			n1=scanner.nextInt();
			
			System.out.println("Enter the number2......");
			n2=scanner.nextInt();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
				CallableStatement cstmt=con.prepareCall("{?= call Sum7(?,?)}");
				cstmt.setInt(1, n1);
				cstmt.setInt(2, n2);
				cstmt.execute();
				System.out.println("Sucess...........");
			}catch(Exception e) {
				e.printStackTrace();
			}
			scanner.close();
		}

}
