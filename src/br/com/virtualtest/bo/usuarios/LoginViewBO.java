package br.com.virtualtest.bo.usuarios;

import br.com.virtualtest.exception.usuarios.LoginViewException;
import br.com.virtualtest.model.usuarios.Usuario;

public class LoginViewBO {
	
	public static boolean validarLogin(Usuario u) throws LoginViewException{
		
		if(u != null){
			return true;
		}else{
			throw new LoginViewException("\nErro no Login, tente novamente!");
		}
		
	}
	
}