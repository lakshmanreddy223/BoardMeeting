package com.propertiesandsql;

public class PropertiesVars {

	private static final String CSVPATH="A_CSVDownloadPath";
	private static final String MYSQLDEIVER="B_mysqlDriver";
	private static final String MYSQLCONECTION="C_mysqConnection";
	private static final String MYSQLDBNAME="D_mysqlDBName";
	private static final String MYSQLDBUNAME="E_mysqlDBUserName";
	private static final String MYSQLDBPASS="F_mysqlDBPassword";
	
	public PropertiesVars() {}
	
	public static String getCsvpath() {
		return CSVPATH;
	}
	public static String getMysqldeiver() {
		return MYSQLDEIVER;
	}
	public static String getMysqlconection() {
		return MYSQLCONECTION;
	}
	public static String getMysqldbname() {
		return MYSQLDBNAME;
	}
	public static String getMysqldbuname() {
		return MYSQLDBUNAME;
	}
	public static String getMysqldbpass() {
		return MYSQLDBPASS;
	}
	
	public static String getMysqlCompleteConn() {
		return MYSQLCONECTION+MYSQLDBNAME;
	}
	
	
}
