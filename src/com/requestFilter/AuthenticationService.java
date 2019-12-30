package com.requestFilter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.StringTokenizer;

import com.boardmeetutil.BoardMeetingSql;
import com.boardmeetutil.DBConnection;
import com.serverinit.ConfigListener;

public class AuthenticationService {
		
	SimpleDateFormat dateformate=null;
		
		public boolean authenticate(String authCredentials) {

			if (null == authCredentials)
				return false;
			// header value format will be "Basic encodedstring" for Basic
			// authentication. Example "Basic YWRtaW46YWRtaW4="
			final String encodedUserPassword = authCredentials.replaceFirst("Basic"
					+ " ", "");
			String usernameAndPassword = null;
			try {
				byte[] decodedBytes = Base64.getDecoder().decode(
						encodedUserPassword);
				usernameAndPassword = new String(decodedBytes, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			final StringTokenizer tokenizer = new StringTokenizer(
					usernameAndPassword, ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();

			// we have fixed the userid and password as admin
			// call some UserService/LDAP here
			boolean authenticationStatus=false;
			DBConnection con=new DBConnection(BoardMeetingSql.GetAllMembers);
			try {
				ResultSet RSet=con.preparedStatment.executeQuery();
				while(RSet.next()) {
					String uname=RSet.getString("email");
					String dob=RSet.getString("dob");
					dateformate=new SimpleDateFormat(ConfigListener.getProperty("I_DOBStrToDate"));
					Date dobdate=dateformate.parse(dob);
					dateformate.applyPattern(ConfigListener.getProperty("J_AuthNormalizeDate"));
					dob=dateformate.format(dobdate).replace("-","");
					if(uname.equals(username.trim()) && dob.equals(password.trim())) {
						authenticationStatus=true;
						break;
					}	
				}
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
			return authenticationStatus;
		}
		
		public static void main(String args[]) throws UnsupportedEncodingException, ParseException {
			//Base64.getEncoder().encode(arg0)
			/*byte[] decodedBytes = Base64.getDecoder().decode(
					"YWRtaW46YWRtaW4=");
			String str=new String(decodedBytes, "UTF-8");
			System.out.println(str);*/
			SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
			Date dobdate=dft.parse("2015-02-15");
			dft.applyPattern("dd-MM-yyyy");
			System.out.println(dft.format(dobdate).replace("-",""));	
		}
	}
	

