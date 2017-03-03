package br.com.virtualtest.view.prova;

import java.io.IOException;
import java.util.Scanner;

public class ProvaCadastroView {
    
	private static Scanner buffer = new Scanner(System.in);
	
	public static int primeiraQuestao(){
		
		System.out.println("\n*******Ao digitar uma letra errada, será perdido os pontos!*******\n");
		
	    System.out.println("Pergunta 1- Resolva a Equacao x^2-4x-5=0");
	    System.out.println("  a)-5 e 1  b)-10 e 6  c)-1 e 5  d)0 ");//c
	    System.out.print("\nOpcao: ");
	    
	    char letra = 'e';
	    
	    
	    
		try {
			letra = (char)System.in.read();
			buffer.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    if(letra=='c'){
	    	System.out.println("\nReposta Certa\n");
	    	return (int)2;
	    }
	    
	    System.out.println("\nReposta Errada\n");
	    return (int) 0;
	}
	
	public static int segundaQuestao(){
		
		System.out.println("\n*******Ao digitar uma letra errada, será perdido os pontos!*******\n");
		
		System.out.println("Pergunta 2- Sao Paulo e Rio de Janeiro sao as duas grandes metropoles globais existentes");
	    System.out.println("no Brasil. Tais cidades encontram-se classificadas nesse patamar por apresentarem:");
	    System.out.println("  a) Uma maior dinamica de deslocamento intra urbano.");
	    System.out.println("  b) Um maior mercado consumidor.");
	    System.out.println("  c) Uma producao intensiva de materias-primas e produtos primarios.");
	    System.out.println("  d) Um alcance economico em nivel nacional e internacional.");
	    System.out.print("\nOpcao: ");
	    
	    char letra = 'e';
	    
		try {
			letra = (char)System.in.read();
			buffer.nextLine();
		} catch (IOException e) {
			System.out.println("\nQuestão perdida!");
		}
	    
	    if(letra=='d'){
	    	System.out.println("\nReposta Certa\n");
	    	return (int)2;
	    }
	    
	    System.out.println("\nReposta Errada\n");
	    return (int) 0;
	}
	

	public static int terceiraQuestao(){
		
		System.out.println("\n*******Ao digitar uma letra errada, será perdido os pontos!*******\n");
		
		System.out.println("Pergunta 3- Qual a forca de atracao gravitacional entre duas massas de 500 kg distantes 5 m uma da outra?");
	    System.out.println("  a)Fg = 6,67*10^-7 N  b)Fg = -7*10^-7 N c)Fg = 10^7 N d)Fg = 0 N");
	    System.out.print("\nOpcao: ");
	    
		char letra = 'e';
	    
		try {
			letra = (char)System.in.read();
			buffer.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    if(letra=='a'){
	    	System.out.println("\nReposta Certa\n");
	    	return (int)2;
	    }
	    
	    System.out.println("\nReposta Errada\n");
	    return (int) 0;
	}
	
	public static int quartaQuestao(){
		
		System.out.println("\n*******Ao digitar uma letra errada, será perdido os pontos!*******\n");
		
		System.out.println("Pergunta 4- Qual fase da mitose e' caracterizada pelo posicionamento dos cromossomos no equador da ce'lula?");
	    System.out.println("  a)G1.  b)Profase  c)Metafase  d)Anafase ");
	    System.out.print("\nOpcao: ");
	    
		char letra = 'e';
	    
		try {
			letra = (char)System.in.read();
			buffer.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    if(letra=='c'){
	    	System.out.println("\nReposta Certa\n");
	    	return (int)2;
	    }
	    
	    System.out.println("\nReposta Errada\n");
	    return (int) 0;
	}

	public static int quintaQuestao(){
	
		System.out.println("\n*******Ao digitar uma letra errada, será perdido os pontos!*******\n");
	
		System.out.println("Pergunta 5- A propriedade que pode ser atribuida a maioria dos compostos ionicos");
		System.out.println("(compostos caracterizados predominantemente por ligacoes ionicas entre as particulas) e':");
		System.out.println("  a) Dissolvidos em Agua, formam solucoes Acidas.");
		System.out.println("  b) Fundidos (no estado liquido), conduzem corrente eletrica.");
		System.out.println("  c) São moles, quebradicos e cristalinos.");
		System.out.println("  d) Possuem baixos pontos de fusao e ebulicao.");
		System.out.print("\nOpcao: ");
	
		char letra = 'e';
    
		try {
			letra = (char)System.in.read();
			buffer.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
    
		if(letra=='b'){
			System.out.println("\nReposta Certa\n");
			return (int)2;
		}
    
		System.out.println("\nReposta Errada\n");
		return (int) 1;
	
	}	
	
	
	public static int prova(){
    
		int pontos = 0;
		
		System.out.println("\nAgora Responda Essas 5 Perguntas para definir seu nivel de usuário (Aluno, Monitor e Professor)!");
		System.out.println("Cada pergunta acertada é 2 pontos (total de 10 pontos), assim sua a classificação será se acertar:");
		System.out.println("6 pontos ou menos: Aluno");
		System.out.println("8 pontos: Monitor");
		System.out.println("10 pontos: Professor");
		System.out.println("\n**********************BOA SORTE******************");
		
		pontos += primeiraQuestao();
		pontos += segundaQuestao();
		pontos += terceiraQuestao();
		pontos += quartaQuestao();
		pontos += quintaQuestao();
		
    	return pontos; 
	}
}
