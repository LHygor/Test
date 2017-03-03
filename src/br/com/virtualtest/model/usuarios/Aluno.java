package br.com.virtualtest.model.usuarios;

public class Aluno extends Usuario implements TypeUser{

	private String nomeCompleto;
	
	public Aluno(char type) {
		super(type);
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String fullName) {
		this.nomeCompleto = fullName;
	}

	@Override
	public char getTypeUserInterface() {
		return (char)'a';
	}

	@Override
	public Aluno getUser(Usuario u) {
		return null;//Chama o AlunoDAO...
	}

}
