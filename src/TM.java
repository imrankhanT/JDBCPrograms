import java.io.*;
import java.sql.*;
import java.util.*;

public class TM {

	public static void main(String[] args) {
       Connection con=null;
       try {
    		Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
			
			con.setAutoCommit(false);
			PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?)");  
			
            Scanner scanner = new Scanner(System.in);
			
			while(true) {
			System.out.println("Enter id..");
			int id=scanner.nextInt();
			
			System.out.println("Enter name....");
			String name=scanner.next();
			
			System.out.println("Enter phone number....");
			int phNum=scanner.nextInt();
			
			System.out.println("Enter job title......");
			String job=scanner.next();
			
			System.out.println("commit/rollback");
			String cr=scanner.next();
			
			if(cr.equals("commit")) {
				con.commit();
			}
			
			if(cr.equals("rollback")) {
				con.rollback();
			}
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, phNum);
			pstmt.setString(4, job);
			pstmt.executeUpdate();
			
			System.out.println("Want to add more records y/n");  
			String ans=scanner.next();  
			if(ans.equals("n")){  
			break;  
			}  
			}
			con.commit();
			System.out.println("Record sucessfully saved..........");
			
       }catch(Exception e) {
    	   e.printStackTrace();
       }
	}

}
