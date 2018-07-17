package entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEstado;
	private String nomeEstado;
	private Vaga vaga;
	
	public Estado() {
		// TODO Auto-generated constructor stub
	}

	public Estado(Integer idEstado, String nomeEstado) {
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
	}
	
	

	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", nomeEstado=" + nomeEstado + "]";
	}
	

	public Estado(Integer idEstado) {
		this.idEstado = idEstado;
	}

//	@Override
//	public String toString() {
//		return "Estado [idEstado=" + idEstado + "]";
//	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}
