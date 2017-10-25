package com.BridgeLabz.Programs;

import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class preparedStatement {

	public static void main(String[] args) {
		try {
			java.sql.Connection con=null;
			java.sql.Statement stmt=null;
			
				//1.Load the driver
				DriverManager.registerDriver(new Driver());
				
				//2.Establish connectio
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
				
				//3.create statement
				stmt=con.createStatement();
				
				Scanner scanner=new Scanner(System.in);
				String name,job;
				int id,phone_Number;
				System.out.println("Enter the id......");
				id=scanner.nextInt();
				System.out.println("Enter the name......");
				name=scanner.next();
				System.out.println("Enter the phone number....");
				phone_Number=scanner.nextInt();
				System.out.println("Entrer the job title.....");
				job=scanner.next();
            	java.sql.PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?)");
                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setInt(3, phone_Number);
                pstmt.setString(4, job);

               int count = pstmt.executeUpdate();
               System.out.println("Number of rows effected count is........."+count);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
