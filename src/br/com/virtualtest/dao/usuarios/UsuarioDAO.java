package br.com.virtualtest.dao.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.virtualtest.dao.ConnectFactory;
import br.com.virtualtest.model.usuarios.Usuario;

public class UsuarioDAO {
	
	//create
	
	public static boolean create(Usuario u){
		
		Connection con = ConnectFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO usuario(user_name, senha, type_user) VALUES (?,?,?)");
			stmt.setString(1, u.getUserName());
			stmt.setString(2, u.getPass());
			stmt.setString(3, String.valueOf(u.getTypeUser()));
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com banco de dados: " + e.getMessage());
		}finally{
			ConnectFactory.closeConnection(con, stmt);
		}
		
		return false;
	}
	
	//read
	
	public static boolean checkLogin(String userName, String senha){
		
		Connection con = ConnectFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("SELECT * FROM usuario WHERE user_name = ? AND senha = ?");
			stmt.setString(1, userName);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com banco de dados: " + e.getMessage());
		}finally{
			ConnectFactory.closeConnection(con, stmt, rs);
		}
		
		return false;
	}
	
	public static Usuario readUsuario(String userName, String senha){
		
		Connection con = ConnectFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			
			stmt = con.prepareStatement("SELECT * FROM usuario WHERE user_name = ? AND senha = ?");
			stmt.setString(1, userName);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				
				Usuario u = new Usuario(rs.getString("type_user").charAt(0));
				u.setUserName(rs.getString("user_name"));
				u.setPass(rs.getString("senha"));
				
				return u;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com banco de dados: " + e.getMessage());
		}finally{
			ConnectFactory.closeConnection(con, stmt, rs);
		}
		
		return null;
	}
	
	public static ArrayList<String> readUserNames(){
		
		Connection con = ConnectFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <String> userNames = new ArrayList<String>();
		
		try {
			
			stmt = con.prepareStatement("SELECT user_name FROM usuario");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				String userName = rs.getString("user_name");
				userNames.add(userName);
			}
			
			return userNames;
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com a verificação de usuarios já existentes: " + e.getMessage());
		}finally{
			ConnectFactory.closeConnection(con, stmt, rs);
		}
		
		return null;
	}
	
	public static int idUsuario(String userName){
		
		Connection con = ConnectFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = con.prepareStatement("SELECT id FROM usuario WHERE user_name = ?");
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				return (int)rs.getInt("id");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com banco de dados: " + e.getMessage());
		}
		
		return 0;
	}
	
	//update
	//delete
}
