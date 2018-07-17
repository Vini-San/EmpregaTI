package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;

import entity.Estado;
import entity.Login;
import entity.Status;
import entity.Vaga;
import persistence.VagaDao;


@Path("/vaga")
public class WSVagas {
	
	@GET
	@Path("/gravar/{requisitos}/{conteudo}/{empresa}/{pretensao}/{cidade}/{idlogin}/{idstatus}/{idestado}")
	@Produces("text/plain")
	public String gravar(@PathParam("requisitos")String requisitos, 
						 @PathParam("conteudo")String conteudo,
						 @PathParam("empresa")String empresa,
						 @PathParam("pretensao")String pretensao,
						 @PathParam("cidade")String cidade,
						 @PathParam("idlogin")String idlogin,
						 @PathParam("idstatus")String idstatus,
						 @PathParam("idestado")String idestado) {
		
		Vaga vaga = new Vaga(null,null,requisitos,conteudo,empresa,pretensao,cidade);
		Login log = new Login(new Integer(idlogin),null,null,null,null);
		Status status = new Status(new Integer(idstatus),null);
		Estado estado = new Estado(new Integer(idestado),null);
		List<Estado> lst = new ArrayList<Estado>();
		lst.add(estado);
		vaga.adicionar(estado);
		

		try {
			new VagaDao().create(log, vaga, status,lst);
			return "Dados Gravados";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
//	http://localhost:12565/EmpregaTiProject/json/vaga/gravar/Desenvolvedor fullstack/Empresa Tal contrata profissional inovador/Rio de Janeiro/Empresa tal/R$ 4.000,00/1/1/24
}
