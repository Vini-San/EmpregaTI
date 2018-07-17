package persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import dto.DtoVagaLoginStatus;
import dto.DtoVagaLoginStatusEstado;
import entity.Estado;
import entity.Login;
import entity.Status;
import entity.Vaga;

public class VagaDao extends Dao{
	
	public void create (Login l, Vaga v, Status s, List<Estado> e) throws Exception{
		open();
		stmt = con.prepareStatement("insert into vaga values (null,CURDATE(),?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, v.getRequisitos());
		stmt.setString(2, v.getConteudo());
		stmt.setString(3, v.getPretensao());
		stmt.setString(4, v.getEmpresa());
		stmt.setString(5, v.getCidade());
		stmt.setInt(6, l.getIdLogin());
		stmt.setInt(7, s.getIdStatus());
		stmt.execute();
		rs = stmt.getGeneratedKeys();
		rs.next();
		v.setIdVaga(rs.getInt(1));
		stmt.close();
		for (Estado x : e) {
		stmt = con.prepareStatement("insert into vagaestado values (?,?)");
		stmt.setInt(1, x.getIdEstado());
		stmt.setInt(2, v.getIdVaga());
		stmt.execute();
		stmt.close();
		}
		con.setAutoCommit(true);
		close();
	}
	
	public List<DtoVagaLoginStatus> findAll() throws Exception{
		
		open();
		stmt = con.prepareStatement("select * from vaga");
		rs = stmt.executeQuery();
		List<DtoVagaLoginStatus> lst = new ArrayList<DtoVagaLoginStatus>();
		while (rs.next()) {
			DtoVagaLoginStatus dto = new DtoVagaLoginStatus();
			dto.setLogin(new Login());
			dto.setStatus(new Status());
			dto.setVaga(new Vaga());
			dto.getVaga().setIdVaga(rs.getInt(1));
			dto.getVaga().setData(rs.getDate(2));
			dto.getVaga().setRequisitos(rs.getString(3));
			dto.getVaga().setConteudo(rs.getString(4));
			dto.getVaga().setCidade(rs.getString(5));
			dto.getVaga().setEmpresa(rs.getString(6));
			dto.getVaga().setPretensao(rs.getString(7));
			dto.getLogin().setIdLogin(rs.getInt(8));
			dto.getStatus().setIdStatus(rs.getInt(9));
			lst.add(dto);
		}	
		close();
		return lst;
	}
	public List<DtoVagaLoginStatusEstado> findByAcesso(Integer cod) throws Exception{
		
		open();
		stmt = con.prepareStatement("select v.data, v.requisitos, v.conteudo, v.cidade,"
				+ " v.empresa, v.pretensao, s.tipo, e.nome from vaga v"
				+ " left join status s on v.idStatus = s.idStatus"
				+ " right join vagaestado ve on v.idVaga = ve.idVaga"
				+ " right join estado e on ve.idEstado = e.idEstado"
				+ " where s.idstatus = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		List<DtoVagaLoginStatusEstado> lst = new ArrayList<DtoVagaLoginStatusEstado>();
		while (rs.next()) {
			
			DtoVagaLoginStatusEstado dto = new DtoVagaLoginStatusEstado();
			dto.setLogin(new Login());
			dto.setStatus(new Status());
			dto.setVaga(new Vaga());
			dto.setEstado(new Estado());
			dto.getVaga().setData(rs.getDate(1));
			dto.getVaga().setRequisitos(rs.getString(2));
			dto.getVaga().setConteudo(rs.getString(3));
			dto.getVaga().setCidade(rs.getString(4));
			dto.getVaga().setEmpresa(rs.getString(5));
			dto.getVaga().setPretensao(rs.getString(6));
			dto.getStatus().setTipo(rs.getString(7));
			dto.getEstado().setNomeEstado(rs.getString(8));
			
			lst.add(dto);
		}
		close();
		return lst;
	}
	public List<DtoVagaLoginStatusEstado> findByEstado(Integer cod) throws Exception{
		
		open();
		stmt = con.prepareStatement("select v.data, v.requisitos, v.conteudo, v.cidade, v.empresa, v.pretensao, s.tipo, e.nome from vaga v"
				+ " left join status s on v.idStatus = s.idStatus"
				+ " right join vagaestado ve on v.idVaga = ve.idVaga"
				+ " right join estado e on ve.idEstado = e.idEstado"
				+ " where e.idEstado = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		List<DtoVagaLoginStatusEstado> lst = new ArrayList<DtoVagaLoginStatusEstado>();
		while (rs.next()) {
			
			DtoVagaLoginStatusEstado dto = new DtoVagaLoginStatusEstado();
			dto.setLogin(new Login());
			dto.setStatus(new Status());
			dto.setVaga(new Vaga());
			dto.setEstado(new Estado());
			dto.getVaga().setData(rs.getDate(1));
			dto.getVaga().setRequisitos(rs.getString(2));
			dto.getVaga().setConteudo(rs.getString(3));
			dto.getVaga().setCidade(rs.getString(4));
			dto.getVaga().setEmpresa(rs.getString(5));
			dto.getVaga().setPretensao(rs.getString(6));
			dto.getStatus().setTipo(rs.getString(7));
			dto.getEstado().setNomeEstado(rs.getString(8));
			
			lst.add(dto);
		}
		close();
		return lst;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
//		Vaga vaga = new Vaga(null,null,"Programador Front End","PJ. Angular4, Ionic, React, Cordova","Não informado","R$ 1.500,00","Rio de Janeiro");
//		Login log = new Login();
//		log.setIdLogin(1);
//		Status status = new Status();
//		status.setIdStatus(1);
//		Estado uf1 = new Estado(23);
//		Estado uf2 = new Estado(25);
//		Estado uf3 = new Estado(26);
//		List<Estado> lst = new ArrayList<Estado>();
//		lst.add(uf1);
//		lst.add(uf2);
//		lst.add(uf3);
//		vaga.adicionar(uf1);
//		vaga.adicionar(uf2);
//		vaga.adicionar(uf3);
		
		
		
		try {
//			new VagaDao().create(log, vaga,status,lst);
			
//			System.out.println("Dados Gravados");
//			System.out.println(new VagaDao().findAll());
			System.out.println(new VagaDao().findByEstado(23));
//			System.out.println(new VagaDao().findByAcesso(2));
//			System.out.println("Cadastrado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
