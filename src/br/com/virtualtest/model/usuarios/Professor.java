package br.com.virtualtest.model.usuarios;

public class Professor extends Usuario implements TypeUser{
	
	private String nomeCompleto;
	private String materia;
	
	public Professor(char type) {
		super(type);
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String fullName) {
		this.nomeCompleto = fullName;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String matter) {
		this.materia = matter;
	}

	@Override
	public char getTypeUserInterface() {
		return (char)'p';
	}
	
	@Override
	public Professor getUser(Usuario u) {
		return null;//Chamar ProfessorDAO...
	}

}
