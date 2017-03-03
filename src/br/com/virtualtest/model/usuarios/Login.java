package br.com.virtualtest.model.usuarios;

public interface Login {
	public boolean singIn(String userName, String pass);
	public void singOut();
}
