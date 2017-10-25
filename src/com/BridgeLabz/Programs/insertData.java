package com.BridgeLabz.Programs;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class insertData {

	public static void main(String[] args) throws SQLException {
		java.sql.Connection con=null;
		java.sql.Statement stmt=null;
	try {
		
		
			//1.Load the driver
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2.Establish connectio
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
			
			//3.create statement
			stmt=con.createStatement();
			
			int count=stmt.executeUpdate("insert into employee value(111,'Rajesh',1234,'tester')");
			System.out.println("Number of rows affted "+count);
			
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		con.close();
		stmt.close();
	}

	}

}
