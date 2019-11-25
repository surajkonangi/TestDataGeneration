package com.atmecs.assesment.qaautomation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnection {

	ResultSet rs = null;
	Statement stmt = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	String expectedvalue;

	public String db(String databaseName, String tableName, String columnName, int rowNo) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/" + databaseName + "?user=root&password=Dadmom@143");

			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs = stmt.executeQuery("select * from " + tableName);

			/*
			 * pstmt = con.
			 * prepareStatement("insert into ninjastore (productname,quantity) values(?,?)"
			 * ); pstmt.setInt(1, 2); pstmt.setString(2,"iphone"); pstmt.executeUpdate();
			 */
			while (rs.next()) {
				String getAllIndex = rs.getString(1);
				int row = Integer.parseInt(getAllIndex);
				if (row == rowNo) {
					expectedvalue = rs.getString(columnName);
				}

			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return expectedvalue;
	}

	public static void main(String[] args) {
		JDBConnection dataBase = new JDBConnection();
		String s = dataBase.db("assessment", "ninjastore", "productname", 1);
		System.out.println(s);
	}
}

//databasename
//select columnName
//from tableName
//where rowindex=1;