package com.dsmentoring.log4jPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBC {
	
	private static final Logger LOG = LogManager.getLogger(LDAPUnbound.class);
	
	public JDBC() {
		
	}
	
	public static Connection connectDB(String ip, String id, String pw) throws ClassNotFoundException, SQLException {            
		
		Connection con;
	    Class.forName("com.mysql.cj.jdbc.Driver"); 
		con = DriverManager.getConnection("jdbc:mysql://" +ip+"?useSSL=false&serverTimezone=UTC", id, pw);
          
		LOG.info(con);
	    
		return con;
    }	

	public static void select(Connection con, String USRIDX ) throws ClassNotFoundException { 
	
	String sql = "SELECT * from test where USRIDX =" + USRIDX;
	
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				String a = rs.getString(1);
				String b = rs.getString(2); 
				String c = rs.getString(3); 
				LOG.info(a +" " + b + " "+c );
				
			} 
		} catch(SQLException e) {
			LOG.info(e.getMessage());
		}
	}	
	
	public static void closeJDBC(Connection con) throws SQLException {
		con.close();
		LOG.info("짜이찌엔");
	}
	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			Connection con =connectDB("192.168.0.32/SAC","SAC","SAC");
			select(con,"1");  
			closeJDBC(con);
		}
}