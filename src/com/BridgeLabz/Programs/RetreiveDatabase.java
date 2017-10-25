package com.BridgeLabz.Programs;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class RetreiveDatabase {

	public static void main(String[] args) throws Exception {
		java.sql.Connection con=null;
		java.sql.Statement stmt=null;
		
		try {
			//1.Load the driver
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2.Establish connectio
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
			
			
			stmt=con.createStatement();
			
			java.sql.ResultSet rs=stmt.executeQuery("select * from employee");
			
			while(rs.next()) {
				System.out.println("Employee ID----->"+rs.getInt(1));
				System.out.println("Employee Name---->"+rs.getString(2));
				System.out.println("Employee Phone---->"+rs.getInt(3));
				System.out.println("Employee Job------->"+rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
