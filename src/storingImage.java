import java.io.*;
import java.sql.*;

public class storingImage {

	public static void main(String[] args) {
        Connection con=null;   
try {
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
	
	PreparedStatement pstmt=con.prepareStatement("insert into userImages values(?,?)");
	pstmt.setString(1, "Siddu(Congress)");

	FileInputStream file=new FileInputStream("/home/bridgeit/Downloads/congress.jpg");
	pstmt.setBinaryStream(2,file,file.available());  
	int record=pstmt.executeUpdate();
	System.out.println(record+" Records are updated..........");
    }catch(Exception e) {
	e.printStackTrace();
                        }
	}
}
