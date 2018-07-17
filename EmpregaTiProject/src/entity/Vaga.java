package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Vaga implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idVaga;
	private Date data;
	private String requisitos;
	private String conteudo;	
	private String pretensao;
	private String empresa;
	private String cidade;
	
	private Login login;
	private List<Estado> estados;
	private Status status;
	
	public Vaga() {
		// TODO Auto-generated constructor stub
	}

	public Vaga(Integer idVaga, Date data, String requisitos, String conteudo,String pretensao, String empresa, String cidade) {
		this.idVaga = idVaga;
		this.requisitos = requisitos;
		this.conteudo = conteudo;
		this.cidade = cidade;
		this.data = data;
		this.empresa = empresa;
		this.pretensao = pretensao;
	}

	@Override
	public String toString() {
		return "Vaga [idVaga=" + idVaga + ", data=" + data + ", requisitos=" + requisitos + ", conteudo=" + conteudo
				+ ", pretensao=" + pretensao + ", empresa=" + empresa + ", cidade=" + cidade + "]";
	}

	public Integer getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPretensao() {
		return pretensao;
	}

	public void setPretensao(String pretensao) {
		this.pretensao = pretensao;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public List<Estado> getEstado() {
		return estados;
	}

	public void setEstado(List<Estado> estados) {
		this.estados = estados;
	}

	public void adicionar(Estado ...e) {
		if(estados ==null) {
			estados = new ArrayList<Estado>();
		}
		for (Estado x: e) {
		estados.add(x);
		}
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(new Vaga(1,"Programador Java, PL/SQL, junior","Trabalhar na empresa XYZ com implementações inovadoras", "Rio de Janeiro","RJ", new Date()));
//		
//	}
	
}
