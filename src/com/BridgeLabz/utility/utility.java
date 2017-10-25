package com.BridgeLabz.utility;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class utility {
	static java.sql.Connection con = null;
	static java.sql.Statement stmt = null;
	static Scanner scanner=new Scanner(System.in);
public static void insertPreparedStatement() throws SQLException{
	int id,phone;
	String name,job;
	
	
	try {
		//2.Establish connectio
		con=getConnections();
		
		//3.create statement
		stmt=con.createStatement();

		System.out.println("Enter the id.....");
		id=scanner.nextInt();
		System.out.println("Enter the name of the user......");
		name = scanner.next();
		System.out.println("Enter the phone number.....");
		phone=scanner.nextInt();
		System.out.println("Enter the job title.....");
		job = scanner.next();
		
		java.sql.PreparedStatement pstmt = pstmt=con.prepareStatement("insert into employee values(?,?,?,?)");
		 pstmt.setInt(1, id);
         pstmt.setString(2, name);
         pstmt.setInt(3, phone);
         pstmt.setString(4, job);

         int count = pstmt.executeUpdate();
         System.out.println("Number of rows effected count is...."+count);
	}catch(Exception e) {
	e.printStackTrace();
	}
}
public static void deleteRecord() throws Exception {
	int id;
	System.out.println("Enter the id of the employee");
	id=scanner.nextInt();
	//1.Load the driver
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2.Establish connectio
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
			
			//3.create statement
			java.sql.PreparedStatement pstmt=con.prepareStatement("delete from employee where Eid=?");  
			pstmt.setInt(1,id);  
			int i=pstmt.executeUpdate();  
			System.out.println(i+" records deleted");  

	
}
public static void updateRecord() throws Exception {
	int updatedrecord,id;
	String name;
	java.sql.Statement stmt=null;
	boolean found=false;
	System.out.println("Enter the id of the employee");
	updatedrecord=scanner.nextInt();
	System.out.println("Enter the name of the employee to change");
	name=scanner.next();
			//2.Establish connectio
			con=getConnections();
			
			stmt=con.createStatement();
			//3.create statement
			java.sql.ResultSet rs = stmt.executeQuery("Select * from employee");
			
			while(rs.next()) {
				id=rs.getInt(1);			
				if(id==updatedrecord) {
					found=true;
				}
			}

			java.sql.PreparedStatement pstmt = con.prepareStatement("update employee set Ename= ? where Eid=?");
			pstmt.setString(2, "%" + updatedrecord + "%");
			pstmt.setString(1, name);
			
			int i=pstmt.executeUpdate();  
			System.out.println(i+" records updated");  
}
public static void displayRecord() throws Exception {

	
	//2.Establish connectio
	con=getConnections();
	
	//3.create statement
	stmt=con.createStatement();
	java.sql.ResultSet resultSet = stmt.executeQuery("Select * from employee");
	
	while(resultSet.next()) {
		System.out.println("Employee ID----->"+resultSet.getInt(1));
		System.out.println("Employee Name---->"+resultSet.getString(2));
		System.out.println("Employee Phone---->"+resultSet.getInt(3));
		System.out.println("Employee Job------->"+resultSet.getString(4));
		
		System.out.println("--------------------------------------------------------------------");
	}
	
}

public static java.sql.Connection getConnections() {
	java.sql.Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return con;
	
}
}
