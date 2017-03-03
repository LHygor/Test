package br.com.virtualtest.model.usuarios;

public class Monitor extends Usuario implements TypeUser{

	private String nomeCompleto;
	private String Materia;
	
	public Monitor(char type) {
		super(type);
	}
	
	public String getNomeCompleto() {
		return this.nomeCompleto;
	}

	public void setNomeCompleto(String fullName) {
		this.nomeCompleto = fullName;
	}

	public String getMateria() {
		return this.Materia;
	}

	public void setMateria(String matter) {
		this.Materia = matter;
	}

	@Override
	public char getTypeUserInterface() {
		return (char)'m';
	}

	@Override
	public Monitor getUser(Usuario u) {
		return null;//Chama o MonitorDAO...
	}

}
