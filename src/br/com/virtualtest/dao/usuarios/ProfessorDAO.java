package br.com.virtualtest.dao.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.virtualtest.dao.ConnectFactory;
import br.com.virtualtest.model.usuarios.Professor;
import br.com.virtualtest.model.usuarios.Usuario;

public class ProfessorDAO extends UsuarioDAO{
	
	public static boolean createProfessor(Professor p){
		
		Connection con = ConnectFactory.getConnection();
		PreparedStatement stmt = null;
		
		Usuario u = new Usuario(p.getTypeUserInterface());
		u.setUserName(p.getUserName());
		u.setPass(p.getPass());
		
		if(UsuarioDAO.create(u)){
			
			int idUsuario = UsuarioDAO.idUsuario(p.getUserName());
			
			if(idUsuario != 0){
				
				try {
					
					stmt = con.prepareStatement("INSERT INTO professor (id_usuario, nome_completo, materia) VALUES (?,?,?)");
					stmt.setInt(1, idUsuario);
					stmt.setString(2, p.getNomeCompleto());
					stmt.setString(3, p.getMateria());
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
