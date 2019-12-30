package com.boardmeetutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.serverinit.ConfigListener;


public class CommonUtils {

	private static Map<String, String> proplist = null;

	private CommonUtils() {
	}

	/**
	 * getResourceProperties method load properties from "NiyoginProps.xml" if
	 * proplist is null
	 */
	public static void getResourceProperties(String str) {
		System.out.println("4");
		System.out.println("Context Path==" + str);
		try {
			File file = new File(str);
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.loadFromXML(fis);
			Enumeration<Object> enuKeys = prop.keys();
			proplist = new TreeMap<String, String>();
			int cnt = 0;
			while (enuKeys.hasMoreElements()) {
				cnt++;
				String key = (String) enuKeys.nextElement();
				String value = prop.getProperty(key);
				proplist.put(key, value);
				System.out.println(cnt + ":" + key + ": " + value);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static Map<String, String> getPropList(String path) {
		System.out.println("1");
		if (proplist == null) {
			System.out.println("2");
			getResourceProperties(path);
		} else {
			System.out.println("3");
			System.out.println("Enter into else getPropList");
		}
		return proplist;
	}

	public static void getPath() {
		System.out.println("fdsf");// InvoiceService.xmlpath);
	}

	public static Connection dbConnection() {
		Connection con = null;
		try {
			System.out.println("");
			Class.forName("");
			System.out.println("Connection created");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public static void main(String args[]) throws SQLException {
		Connection con=testConnection();
		PreparedStatement pstmt= con.prepareStatement(BoardMeetingSql.UserMeetings);
		pstmt.setInt(1, 26);
		ResultSet rset=pstmt.executeQuery();
		while(rset.next()) {
	         System.out.println(rset.getString("title"));	
		}
	}
	
	
	public static Connection testConnection() {
		Connection con = null;
		try {
			System.out.println(ConfigListener.getProperty("B_mysqlDriver"));
			Class.forName(ConfigListener.getProperty("B_mysqlDriver"));
			con = DriverManager.getConnection(ConfigListener.getProperty("D_mysqDBConnection"),ConfigListener.getProperty("E_mysqlDBUserName"), ConfigListener.getProperty("F_mysqlDBPassword"));		
			System.out.println("Connection created");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static void newConnection() {
	 
	  PreparedStatement pst;
	  try {
		 Connection con=dbConnection();
		pst = con.prepareStatement("select * from invoic_file_data");
	   ResultSet rset=pst.executeQuery();
	  while(rset.next()) {
		System.out.println( rset.getInt(1));
		System.out.println( rset.getString(2));
		System.out.println( rset.getLong(3));
	  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
     
}
