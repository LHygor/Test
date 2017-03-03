package br.com.virtualtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectFactory {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bd_virtual_test_";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexão: " + e);
		}
	}
	
	public static void closeConnection(Connection con){
		
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt){
	
		closeConnection(con);
	
		try {
			if(stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet res){
		
		closeConnection(con, stmt);
	
		try {
			if(res != null)
				res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
