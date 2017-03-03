package br.com.virtualtest.model.usuarios;

import br.com.virtualtest.dao.usuarios.UsuarioDAO;

public class Usuario implements Login{
	
	private String userName;
	private String pass;
	private char typeUser;
	
	public Usuario(char type){
		this.typeUser = type;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public char getTypeUser() {
		return typeUser;
	}
	
	@Override
	public boolean singIn(String userName, String pass) {
			return UsuarioDAO.checkLogin(userName, pass);
	}
	
	public void singOut() {
		System.out.println("Volte sempre há Escola VirtualTest!");
	}
}
