package br.com.virtualtest.dao.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.virtualtest.dao.ConnectFactory;
import br.com.virtualtest.model.usuarios.Aluno;
import br.com.virtualtest.model.usuarios.Usuario;

public class AlunoDAO extends UsuarioDAO{
	
	public static boolean createAluno(Aluno a){
		
		Connection con = ConnectFactory.getConnection();
		PreparedStatement stmt = null;
		
		Usuario u = new Usuario(a.getTypeUserInterface());
		u.setUserName(a.getUserName());
		u.setPass(a.getPass());
		
		if(UsuarioDAO.create(u)){
			
			int idUsuario = UsuarioDAO.idUsuario(a.getUserName());
			
			if(idUsuario != 0){
				
				try {
					
					stmt = con.prepareStatement("INSERT INTO aluno (id_usuario, nome_completo) VALUES (?,?)");
					stmt.setInt(1, idUsuario);
					stmt.setString(2, a.getNomeCompleto());
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
