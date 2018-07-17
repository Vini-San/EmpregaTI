package entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idStatus;
	private String tipo;
	private Vaga vaga;
	
	public Status() {
		// TODO Auto-generated constructor stub
	}

	public Status(Integer idStatus, String tipo) {
		this.idStatus = idStatus;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Status [idStatus=" + idStatus + ", tipo=" + tipo + "]";
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	
	

}
