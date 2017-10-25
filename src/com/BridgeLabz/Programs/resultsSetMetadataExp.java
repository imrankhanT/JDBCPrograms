package com.BridgeLabz.Programs;

import java.sql.*;

import com.mysql.jdbc.Statement;

public class resultsSetMetadataExp {

	public static void main(String[] args) {
	
		Statement stmt=null;
		Connection con=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emplyee_Info","root","imran");
		PreparedStatement pstmt = con.prepareStatement("select * from employee");
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		
		System.out.println("number of column is....."+rsmd.getColumnCount());
		System.out.println("Column type is........."+rsmd.getColumnTypeName(2));
		System.out.println("Column name is........"+rsmd.getColumnName(2));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
