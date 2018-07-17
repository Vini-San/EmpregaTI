package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import entity.Login;
import entity.Acesso;
import persistence.LoginDao;

@Path("/login")
public class WSlogin {
	
	@GET
	@Path("/create/{email}/{senha}/{nome}/{tipo}")
	@Produces("text/plain")
	public String gravar(@PathParam("email") String email,
						 @PathParam("senha") String senha,
						 @PathParam("nome") String nome,
						 @PathParam("tipo") String tipo) {
		
		try {
			Login log = new Login(null,email,senha,nome,null);
			Acesso tip = new Acesso(new Integer(tipo),null);
			new LoginDao().create(log,tip);
			return "Dados Gravados";
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@POST
	@Path("/createpost")
	@Produces("text/plain")
	public String gravarpost(Login l, Acesso t) {
		
		try {
			
			new LoginDao().create(l,t);
			return "Dados Gravados";
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@GET
	@Path("/listartudo")
	@Produces("application/json")
	public String findAll() {
		
		try {
			
			return new Gson().toJson(new LoginDao().findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@GET
	@Path("/listarcomum")
	@Produces("application/json")
	public String findAllEdit() {
		
		try {
			
			return new Gson().toJson(new LoginDao().findAllEdit());
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@GET
	@Path("/buscaremail/{email}")
	@Produces("application/json")
	public String buscaremail(@PathParam("email")String email) {
		
		try {
			return new Gson().toJson(new LoginDao().buscarLogin(email));
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@GET
	@Path("/buscartipo/{tipo}")
	@Produces("application/json")
	public String buscarTipo(@PathParam("tipo")String tipo) {
		
		try {
			return new Gson().toJson(new LoginDao().findByType(new Integer(tipo)));
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@GET
	@Path("/logar/{email}/{senha}")
	@Produces("application/json")
	public String logar(@PathParam("email")String email,
						  @PathParam("senha")String senha) {
		
		try {
			
			return new Gson().toJson(new LoginDao().logar(email, senha));
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@POST
	@Path("/logarpost")
	@Consumes("application/json")
	@Produces("text/plain")
	public String logarpost(String email, String senha) {
		
		try {
			return new Gson().toJson(new LoginDao().logar(email, senha));
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@GET
	@Path("/validar/{email}/{senha}")
	@Produces("application/json")
	public String validar(@PathParam("email")String email,
						  	  @PathParam("senha")String senha) {
		
		try {
			
			return new Gson().toJson(new LoginDao().validar(email, senha));
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@POST
	@Path("/validarpost")
	@Consumes("application/json")
	@Produces("text/plain")
	public String validarpost(String email, String senha) {
		
		try {
			return new Gson().toJson(new LoginDao().validar(email, senha));
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@GET
	@Path("/excluir/{cod}")
	@Produces("application/json")
	public String exlcuir(@PathParam("cod")String cod) {
		
		try {
			
			new LoginDao().delete(new Integer (cod));
			return "Registro Excluido";
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	
	@GET
	@Path("/update/{idLogin}/{email}/{senha}/{nome}/{tipo}")
	@Produces("text/plain")
	public String update(@PathParam("idLogin") String idLogin,
						 @PathParam("email") String email,
						 @PathParam("senha") String senha,
						 @PathParam("nome") String nome,
						 @PathParam("tipo") String tipo) {
		
		try {
			Login log = new Login(new Integer(idLogin),email,senha,nome,null);
			Acesso tip = new Acesso(new Integer(tipo),null);
			new LoginDao().update(log,tip);
			return "Dados Modificados";
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@POST
	@Path("/updatepost")
	@Consumes("application/json")
	@Produces("text/plain")
	public String updatePost(Login l, Acesso t) {
		
		try {
			new LoginDao().update(l,t);
			return "Dados Modificados" + l.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
	}
	
	@GET
	@Path("/updatesenha/{idLogin}/{senha}")
	@Produces("text/plain")
	public String updatesenha(@PathParam("idLogin") String idLogin,
						 	  @PathParam("senha") String senha) {
		
		try {
			Login log = new Login(new Integer(idLogin),null,senha,null,null);
			new LoginDao().updateSenha(log);
			return "Dados Modificados";
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
		
	}
	
	@POST
	@Path("/updatesenhapost")
	@Consumes("application/json")
	@Produces("text/plain")
	public String updatesenhapost(Login l) {
		
		try {
			new LoginDao().updateSenha(l);
			return "Dados Modificados" + l.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "error: "+e.getMessage();
		}
	}

}
