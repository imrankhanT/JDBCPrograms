package com.BridgeLabz.Programs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.ResultSet;

public class deletePstmt {

	public static void main(String[] args) throws SQLException {
		java.sql.Connection con=null;
		java.sql.Statement stmt=null;
		java.sql.PreparedStatement pstmt = null;
		try {
			
			
				//1.Load the driver
				Driver driverRef=new Driver();
				DriverManager.registerDriver(driverRef);
				
				//2.Establish connectio
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
				
				//3.create statement
				stmt=con.createStatement();
				
				Scanner scanner=new Scanner(System.in);
				int id,count;
				boolean found=false;
				System.out.println("Enter the id......");
				id=scanner.nextInt();

				pstmt=con.prepareStatement("select * from employee");
				java.sql.ResultSet rs=pstmt.executeQuery();
				
				
            	
      
                while(rs.next()) {
    				int eid=rs.getInt(1);
    				if(id==eid) {
    					pstmt=con.prepareStatement("delete from employee where Eid=?");
    	                pstmt.setInt(1, id);
    	                count = pstmt.executeUpdate();
    	                System.out.println("Number of rows effected count is........."+count);
    	                found=true;
    	                return;
    				}
				}
                
                if(found==false)
                	System.out.println("The Employee Id is not exsist......");
                
        
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	}
}
