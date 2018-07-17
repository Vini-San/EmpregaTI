package dto;

import entity.Login;
import entity.Acesso;

public class DtoLoginAcesso {
	
	private Login login;
	private Acesso tipo;
	
	public DtoLoginAcesso() {
		// TODO Auto-generated constructor stub
	}

	public DtoLoginAcesso(Login login, Acesso tipo) {
		this.login = login;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return " " + login + " " + tipo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Acesso getTipo() {
		return tipo;
	}

	public void setTipo(Acesso tipo) {
		this.tipo = tipo;
	}
	

}
