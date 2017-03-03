package br.com.virtualtest.dao.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.virtualtest.dao.ConnectFactory;
import br.com.virtualtest.model.usuarios.Monitor;
import br.com.virtualtest.model.usuarios.Usuario;

public class MonitorDAO extends UsuarioDAO{

	public static boolean createMonitor(Monitor m){

		Connection con = ConnectFactory.getConnection();
		PreparedStatement stmt = null;
		
		Usuario u = new Usuario(m.getTypeUserInterface());
		u.setUserName(m.getUserName());
		u.setPass(m.getPass());
		
		if(UsuarioDAO.create(u)){
			
			int idUsuario = UsuarioDAO.idUsuario(m.getUserName());
			
			if(idUsuario != 0){
				
				try {
					
					stmt = con.prepareStatement("INSERT INTO monitor (id_usuario, nome_completo, materia) VALUES (?,?,?)");
					stmt.setInt(1, idUsuario);
					stmt.setString(2, m.getNomeCompleto());
					stmt.setString(3, m.getMateria());
					stmt.executeUpdate();
					
					return true;
				} catch (SQLException e) {
					System.out.println("Erro ao conectar com banco de dados: " + e.getMessage());
				}finally{
					ConnectFactory.closeConnection(con, stmt);
				}
			}
			
		}
		
		return false;
	}
	
}
