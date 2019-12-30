package com.boardmeetutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.serverinit.ConfigListener;

public class DBConnection {

	    public Connection connection = null;
	    public PreparedStatement preparedStatment=null;
	    public static Properties prop = null;
	    
	    public DBConnection() {
	    	
	    }
	    
	    public DBConnection(String sql) {
	        System.out.println("-------- MySQL JDBC Connection Testing ------------");
	        prop = new Properties();
	        try {
	            Class.forName(ConfigListener.getProperty("B_mysqlDriver"));
	            connection = DriverManager.getConnection(
	                    ConfigListener.getProperty("D_mysqDBConnection"),
	                    ConfigListener.getProperty("E_mysqlDBUserName"),  ConfigListener.getProperty("F_mysqlDBPassword"));
	            preparedStatment = connection.prepareStatement(sql);
	        } catch (SQLException e) {
	            System.out.println("Connection Failed! Check output console");
	            e.printStackTrace();
	        }
	        catch (ClassNotFoundException ex) {
	            System.out.println("Connection Failed! Check output console");
	            ex.printStackTrace();
	        }

	        if (connection != null) {
	            System.out.println("You made it, take control your database now!");
	        } else {
	            System.out.println("Failed to make connection!");
	        }

	    }

	    public PreparedStatement createConnection(List<String> conStrList, String SQL) throws ClassNotFoundException {
	    	PreparedStatement innerpstmt=null;
	    	
	    	 try {
		            Class.forName(conStrList.get(0));
		            connection = DriverManager.getConnection(
		            		conStrList.get(1) + conStrList.get(2),
		            		conStrList.get(3), conStrList.get(4));
		            innerpstmt = connection.prepareStatement(SQL);
		        } catch (SQLException e) {
		            System.out.println("Connection Failed! Check output console");
		            e.printStackTrace();
		        }
	    	return innerpstmt;
	    }
	    
	    public ResultSet queryResult(String Query) {
	        ResultSet rst = null;
	        try {
	            rst = preparedStatment.executeQuery(Query);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return rst;
	    }

	    public int queryCount(String Query) {
	        int count = 0;
	        try {
	            count = preparedStatment.executeUpdate(Query);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return count;
	    }
	    public void closeConnection()
	    {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	
}
