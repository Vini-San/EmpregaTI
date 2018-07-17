package dto;

import entity.Estado;
import entity.Vaga;

public class DtoVagaEstado {
	
	private Vaga vaga;
	private Estado estado;
	
	public DtoVagaEstado() {
		// TODO Auto-generated constructor stub
	}

	public DtoVagaEstado(Vaga vaga, Estado estado) {
		this.vaga = vaga;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "DtoVagaEstado [vaga=" + vaga + ", estado=" + estado + "]";
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

}
