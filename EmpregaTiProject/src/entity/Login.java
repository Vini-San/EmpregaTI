package entity;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer idLogin;
	private String email;
	private String senha;
	private String nome;
	private Integer tentativas;
	private Acesso acesso;
	private Vaga vaga;
	
	public Login() {
	}

	public Login(Integer idLogin, String email, String senha, String nome, Integer tentativas) {
		this.idLogin = idLogin;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.tentativas = tentativas;
	}

	public Login(String email, String senha, String nome) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Email=" + email + ", Senha=" + senha + ", Nome=" + nome;
	}
	
	

	public Integer getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public void setTentativas(Integer tentativas) {
		this.tentativas = tentativas;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	

}
