package dto;

import entity.Login;
import entity.Status;
import entity.Vaga;

public class DtoVagaLoginStatus {
	
	private Vaga vaga;
	private Login login;
	private Status status;
	
	public DtoVagaLoginStatus() {
		// TODO Auto-generated constructor stub
	}


	public DtoVagaLoginStatus(Vaga vaga, Login login, Status status) {
		this.vaga = vaga;
		this.login = login;
		this.status = status;
	}

	@Override
	public String toString() {
		return "DtoVagaLoginStatusEstado [vaga=" + vaga + ", login=" + login + ", status=" + status + "]";
	}


	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	

}
