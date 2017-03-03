package br.com.virtualtest.bo.usuarios;

import java.util.ArrayList;

import br.com.virtualtest.dao.usuarios.UsuarioDAO;
import br.com.virtualtest.exception.usuarios.CadastrarViewException;
import br.com.virtualtest.model.usuarios.Aluno;
import br.com.virtualtest.model.usuarios.Monitor;
import br.com.virtualtest.model.usuarios.Professor;

public class CadastrarViewBO {
	
	public static boolean validarGetUserNameView(String name) throws CadastrarViewException{
		
		if(name.length()>30){
			throw new CadastrarViewException("Usuario não pode ter mais de 30 caracteres!");
		}
		
		
		ArrayList <String> userNames = UsuarioDAO.readUserNames();
		
		if(name != null){
			for(int i=0; i<userNames.size(); i++){
				
				String verificacao = userNames.get(i);
				
				if(verificacao.equals(name)){
					throw new CadastrarViewException("Usuario ja existente, tente outro nome para usuario!");
				}
			}
			
		}
		
		return true;
		
	}
	
	public static boolean validarGetPassView(String pass, String passAgain) throws CadastrarViewException{
		
		if(pass.length()>30){
			throw new CadastrarViewException("A senha não pode ter mais de 30 caracteres!");
		}
		
		if(pass.equals(passAgain)){
			return true;
		}else{
			throw new CadastrarViewException("Senha não foi corfimada corretamente!");
		}
		
	}
	
	public static boolean validarGetFullNameView(String name) throws CadastrarViewException{
		
		if(name.length()>50){
			throw new CadastrarViewException("Seu nome completo não pode ter mais de 50 caracteres!");
		}
		
		return true;
	}
	
	public static boolean validarGetMatterView(String materia) throws CadastrarViewException{
		
		if(materia.length()>30){
			throw new CadastrarViewException("O nome da materia não pode ter mais de 50 caracteres!");
		}
		
		return true;
	}
	
	public static boolean validarAluno(Aluno a) throws CadastrarViewException{
		
		if(a.getTypeUser() == a.getTypeUserInterface())
			if(a.getUserName()!= null)
				if(a.getPass() != null)
					if(a.getNomeCompleto() != null)
						return true;
			
		
		throw new CadastrarViewException("Erro ao cadastrar o aluno, tente novamente!");
	}
	
	public static boolean validarMonitor(Monitor m) throws CadastrarViewException{
		
		if(m.getTypeUser() == m.getTypeUserInterface())
			if(m.getUserName() != null)
				if(m.getPass() != null)
					if(m.getNomeCompleto() != null)
						if(m.getMateria() != null)
							return true;
		
		throw new CadastrarViewException("Erro ao cadastrar o monitor, tente novamente!");
	}
	
	public static boolean validarProfessor(Professor p) throws CadastrarViewException{
		
		if(p.getTypeUser() == p.getTypeUserInterface())
			if(p.getUserName()!= null)
				if(p.getPass() != null)
					if(p.getNomeCompleto() != null)
						if(p.getMateria() != null)
							return true;
						
		
		throw new CadastrarViewException("Erro ao cadastrar o professor, tente novamente!");
	}
	
	
	public static boolean validarPontos(int pontos) throws CadastrarViewException{
		
		if(pontos > 0 && pontos <= 10){
			return true;
		}
		else{
			throw new CadastrarViewException("Erro na avalivacao de usuario, tente novamente!");
		}
	}
	
}
