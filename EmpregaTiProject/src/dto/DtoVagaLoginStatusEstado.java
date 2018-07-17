package dto;

import entity.Estado;
import entity.Login;
import entity.Status;
import entity.Vaga;

public class DtoVagaLoginStatusEstado {
	
	private Vaga vaga;
	private Estado estado;
	private Status status;
	private Login login;
	
	public DtoVagaLoginStatusEstado() {
		// TODO Auto-generated constructor stub
	}
	
	public DtoVagaLoginStatusEstado(Vaga vaga, Estado estado, Status status, Login login) {
		this.vaga = vaga;
		this.estado = estado;
		this.status = status;
		this.login = login;
	}
	
	@Override
	public String toString() {
		return "DtoVagaLoginStatusEstado [vaga=" + vaga + ", estado=" + estado + ", status=" + status + ", login="
				+ login + "]";
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}


}
