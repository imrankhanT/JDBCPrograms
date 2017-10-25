import java.io.*;
import java.sql.*;

public class retreiveImage {

	public static void main(String[] args) {
	    Connection con=null;   
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
	    	
	    	PreparedStatement pstmt=con.prepareStatement("select * from userImages");
	    	ResultSet rs=pstmt.executeQuery();

	    
if(rs.next()) {
	Blob b=rs.getBlob(2);//2 means 2nd column data  
	byte barr[]=b.getBytes(1,(int)b.length());
	
	FileOutputStream fout=new FileOutputStream("/home/bridgeit/remains.jpg");  
	fout.write(barr);  
	              
	fout.close();  
	System.out.println("ok");  
}
	        }catch(Exception e) {
	    	e.printStackTrace();
	                            }
	}
}
