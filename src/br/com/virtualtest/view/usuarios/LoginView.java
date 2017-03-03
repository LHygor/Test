package br.com.virtualtest.view.usuarios;

import java.util.Scanner;

import br.com.virtualtest.bo.usuarios.LoginViewBO;
import br.com.virtualtest.dao.usuarios.UsuarioDAO;
import br.com.virtualtest.exception.usuarios.LoginViewException;
import br.com.virtualtest.model.usuarios.Login;
import br.com.virtualtest.model.usuarios.Usuario;

public class LoginView {
	
	static Scanner input = new Scanner(System.in);
	
	private static String userName = null;
	private static String pass = null; 
	
	
	private static String getUserName() {
		return LoginView.userName;
	}
	
	private static String getPass() {
		return LoginView.pass;
	}

	private static void getUserNameView(){
		System.out.print("\nUsuário: ");
		LoginView.userName = input.next();
		input.nextLine();
	}
	
	private static void getPasswordView(){
		System.out.print("Senha: ");
		LoginView.pass = input.next();
		input.nextLine();
	}
	
	public static Usuario getLoginView(Login l) throws LoginViewException{
		
		LoginView.getUserNameView();
		LoginView.getPasswordView();
		
		if(l.singIn(getUserName(), getPass())){
			
			Usuario u = UsuarioDAO.readUsuario(getUserName(), getPass());
			
			try{
				if(LoginViewBO.validarLogin(u)){
					System.out.println("\nSeja bem vindo ao Virtual Tests, seu ambiente de provas virtual!\n");
					return u;
				}
			}catch(LoginViewException e){
				System.out.println(e.getMessage());
			}
			
		}else{
			System.out.println("Digite os campos de usuário ou senha corretamente!");
		}
		
		return null;
	}
	
}
