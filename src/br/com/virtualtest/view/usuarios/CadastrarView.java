package br.com.virtualtest.view.usuarios;

import java.util.Scanner;

import br.com.virtualtest.bo.usuarios.CadastrarViewBO;
import br.com.virtualtest.dao.usuarios.AlunoDAO;
import br.com.virtualtest.dao.usuarios.MonitorDAO;
import br.com.virtualtest.dao.usuarios.ProfessorDAO;
import br.com.virtualtest.dao.usuarios.UsuarioDAO;
import br.com.virtualtest.exception.usuarios.CadastrarViewException;
import br.com.virtualtest.model.usuarios.Aluno;
import br.com.virtualtest.model.usuarios.Monitor;
import br.com.virtualtest.model.usuarios.Professor;
import br.com.virtualtest.model.usuarios.TypeUser;
import br.com.virtualtest.model.usuarios.Usuario;
import br.com.virtualtest.view.prova.ProvaCadastroView;

public class CadastrarView {
	
	Scanner input = new Scanner(System.in);
	
	private Usuario u;
	
	public CadastrarView(){
		this.setUsuario(null);
	}
	
	private void setUsuario(Usuario user){
		u = user;
	}
	
	public Usuario getUsuario(){
		return u;
	}
	
	private String getUserNameView() throws CadastrarViewException{
		
		while(true){
			
			System.out.print("\nUsuario: ");
			String name = input.next();
			input.nextLine();
			
			try {
				if(CadastrarViewBO.validarGetUserNameView(name))
					return name;
			} catch (CadastrarViewException e) {
				System.out.println(e.getMessage());
			}
		
			
			
		}
	}
	
	private String getPassView() throws CadastrarViewException{
		
		while(true){
			
			System.out.print("\nSenha:");
			String pass = input.next();
			input.nextLine();
				
			System.out.print("Confirme sua senha: ");
			String passAgain = input.next();
			input.nextLine(); 
			
			try {
				if(CadastrarViewBO.validarGetPassView(pass, passAgain))
				return pass;
			} catch (CadastrarViewException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	private String getFullNameView(){
		
		System.out.print("\nNome completo: ");
		
		return input.nextLine();
	}
	
	private String getMateriaView(){
		
		System.out.print("\nMateria: ");
		
		return input.nextLine();
	}
	
	private boolean cadastarAluno(TypeUser t) throws CadastrarViewException{
		
		Aluno a = new Aluno(t.getTypeUserInterface());
		
		System.out.println("\nBem-Vindo novo Aluno da Virutal Test!");
		
		System.out.println("\n***Preencha os seguintes campos***\n");
		a.setUserName(this.getUserNameView());
		a.setPass(this.getPassView());
		a.setNomeCompleto(this.getFullNameView());
		
		try{
			if(CadastrarViewBO.validarAluno(a)){
				if(AlunoDAO.createAluno(a)){
					this.setUsuario(UsuarioDAO.readUsuario(a.getUserName(), a.getPass()));
					return !true;
				}
			}
		}catch(CadastrarViewException e){
			System.out.println(e.getMessage());
		}
		
		return !false;
	}
	
	private boolean cadastarMonitor(TypeUser t) throws CadastrarViewException{
		
		Monitor m = new Monitor(t.getTypeUserInterface());
		
		System.out.println("\n***Preencha os seguintes campos***\n");
		m.setUserName(this.getUserNameView());
		m.setPass(this.getPassView());
		m.setNomeCompleto(this.getFullNameView());
		m.setMateria(this.getMateriaView());
		
		try{
			if(CadastrarViewBO.validarMonitor(m)){
				if(MonitorDAO.createMonitor(m)){
					this.setUsuario(UsuarioDAO.readUsuario(m.getUserName(), m.getPass()));
					return !true;
				}
			}
		}catch(CadastrarViewException e){
			System.out.println(e.getMessage());
		}
		
		return !false;
	}
	
	private boolean cadastarProfessor(TypeUser t) throws CadastrarViewException{
		
		Professor p = new Professor(t.getTypeUserInterface());
		
		System.out.println("\n***Preencha os seguintes campos***\n");
		p.setUserName(this.getUserNameView());
		p.setPass(this.getPassView());
		p.setNomeCompleto(this.getFullNameView());
		p.setMateria(this.getMateriaView());
		
		try{
			if(CadastrarViewBO.validarProfessor(p)){
				if(ProfessorDAO.createProfessor(p)){
					this.setUsuario(UsuarioDAO.readUsuario(p.getUserName(), p.getPass()));
					return !true;
				}
			}
		}catch(CadastrarViewException e){
			System.out.println(e.getMessage());
		}
		
		return !false;
	}
	
	public boolean cadastrar(){
		
		int pontos = ProvaCadastroView.prova();
		
		boolean verificacao = !false;
		
		try{
			
			if(CadastrarViewBO.validarPontos(pontos)){
				
				if(pontos>=1 && pontos<=6){
					verificacao = this.cadastarAluno(new Aluno('n'));
				}
				if(pontos>6 && pontos<=8){
					verificacao = this.cadastarMonitor(new Monitor('n'));
				}
				if(pontos>8 && pontos<=10){
					verificacao = this.cadastarProfessor(new Professor('n'));
				}
				
			}
			
		}catch(CadastrarViewException e){
			System.out.println(e.getMessage());
		}
		
		
		return verificacao;
	}
	
}