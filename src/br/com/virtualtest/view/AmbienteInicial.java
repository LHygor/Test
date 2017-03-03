package br.com.virtualtest.view;

import java.util.Scanner;

import br.com.virtualtest.exception.usuarios.LoginViewException;
import br.com.virtualtest.model.usuarios.Usuario;
import br.com.virtualtest.view.usuarios.CadastrarView;
import br.com.virtualtest.view.usuarios.LoginView;

public class AmbienteInicial {
	
	private static Scanner ler = new Scanner(System.in);
	
	private static Usuario u = null;
	 
	
	public static int telaInicial(){
		
        System.out.println("***BEM-VINDO***");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastro;");
        System.out.println("\nPara sair do menu, digite outro número.\n");
		System.out.print("Opcao: ");
        
		//verificar o input
		
		return (int) ler.nextInt();
	}
    
	public static boolean verificarAcao(int acao) throws LoginViewException{
		
		if (acao == 1){
			
			while(u==null){
				
				u = (Usuario)LoginView.getLoginView(new Usuario('n'));
				
			}
			
			verificarAmbienteUsuario();
			
			return true;
        }
        if (acao == 2){
        	
        	CadastrarView c = new CadastrarView();
        	
            while(c.cadastrar());
            
            u = c.getUsuario();
            
        	return true;
        }
		
        return false;
	}

	private static void verificarAmbienteUsuario() {
		
		if(u.getTypeUser() == 'a'){
			//Ambiente Aluno
		}
		
		if(u.getTypeUser() == 'm'){
			//ambiente monitor
		}
		
		if(u.getTypeUser() == 'p'){
			//ambiente prof
		}
		
	}
	
    public static void main(String[] args) throws LoginViewException{
        System.out.println("Início do programa.\n");
        
        while(verificarAcao(telaInicial()));
        
        System.out.println("\nFim do programa.");
    }


    
}