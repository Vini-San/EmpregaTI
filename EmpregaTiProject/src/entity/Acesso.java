package entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Acesso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idAcesso;
	private String acesso;
	
	private Login login;
	
	public Acesso() {
		// TODO Auto-generated constructor stub
	}

	public Acesso(Integer idAcesso, String acesso) {
		this.idAcesso = idAcesso;
		this.acesso = acesso;
	}

	@Override
	public String toString() {
		return "Acesso [idAcesso=" + idAcesso + ", acesso=" + acesso + "]";
	}

	public Integer getIdAcesso() {
		return idAcesso;
	}

	public void setIdAcesso(Integer idAcesso) {
		this.idAcesso = idAcesso;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

		

}
