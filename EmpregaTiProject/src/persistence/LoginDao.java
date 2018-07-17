package persistence;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.jcommon.encryption.SimpleMD5;

import dto.DtoLoginAcesso;
import entity.Login;
import entity.Acesso;

public class LoginDao extends Dao {
	
	public static void criptografia(Login l) {
		SimpleMD5 md5= new SimpleMD5(l.getSenha(), "empregati@empregati.com.br&01-05");
		l.setSenha(md5.toHexString());
	}
	
	public void create (Login l, Acesso a) throws Exception{
		criptografia(l);
		open();
		call = con.prepareCall("{call incluir(?,?,?,?)}");
		call.setString(1, l.getNome());
		call.setString(2, l.getEmail());
		call.setString(3, l.getSenha());
		call.setInt(4, a.getIdAcesso());
		call.execute();
		close();
	}
	
	public String logar(String email, String senha) throws Exception{
		Login log = new Login();
		log.setSenha(senha);
		criptografia(log);
		open();
		call = con.prepareCall("{? = call logar(?,?)}");
		call.registerOutParameter(1, Types.VARCHAR);
		call.setString(2, email);
		call.setString(3, log.getSenha());
		call.execute();
		String resp = call.getString(1);
				
		close();
		return resp;
	}
	
	public String validar(String email, String senha) throws Exception{
		Login log = new Login();
		log.setSenha(senha);
		criptografia(log);
		open();
		call = con.prepareCall("{? = call validar(?,?)}");
		call.registerOutParameter(1, Types.VARCHAR);
		call.setString(2, email);
		call.setString(3, log.getSenha());
		call.execute();
		String resp = call.getString(1);
				
		close();
		return resp;
	}
	
	
	
	public DtoLoginAcesso buscarLogin(String email) throws Exception{
		open();
		stmt = con.prepareStatement("select * from login where email = ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		DtoLoginAcesso dto = null;
		if (rs.next()) {
			dto = new DtoLoginAcesso();
			dto.setLogin(new Login());
			dto.setTipo(new Acesso());
			dto.getLogin().setIdLogin(rs.getInt("idLogin"));
			dto.getLogin().setEmail(rs.getString("email"));
			dto.getLogin().setSenha(rs.getString("senha"));
			dto.getLogin().setNome(rs.getString("nome"));
			dto.getTipo().setIdAcesso(rs.getInt("idAcesso"));
			dto.getLogin().setTentativas(rs.getInt("tentativas"));
		}
		stmt.close();
		close();
		return dto;
		
	}
	
	public List<DtoLoginAcesso> findByType(Integer tipo) throws Exception{
		open();
		stmt = con.prepareStatement("select * from v$buscatipo tip where tip.idTipo = ?");
		stmt.setInt(1, tipo);
		rs = stmt.executeQuery();
		List<DtoLoginAcesso> dtolist = new ArrayList<DtoLoginAcesso>();
		while (rs.next()) {
			
			DtoLoginAcesso dto = new DtoLoginAcesso();
			dto.setLogin(new Login());
			dto.setTipo(new Acesso());

			dto.getLogin().setEmail(rs.getString("email"));
			dto.getLogin().setSenha(rs.getString("senha"));
			dto.getLogin().setNome(rs.getString("nome"));
			dto.getTipo().setIdAcesso(rs.getInt("idTipo"));
			dto.getTipo().setAcesso(rs.getString("acesso"));
			
			
			dtolist.add(dto);
		}
		stmt.close();
		close();
		return dtolist;
		
	}
	
	public List<DtoLoginAcesso> findAll() throws Exception{
		open();
		stmt = con.prepareStatement("select * from login");
		rs = stmt.executeQuery();
		List<DtoLoginAcesso> dtolist = new ArrayList<DtoLoginAcesso>();
		while (rs.next()) {
			
			DtoLoginAcesso dto = new DtoLoginAcesso();
			dto.setLogin(new Login());
			dto.setTipo(new Acesso());
			dto.getLogin().setIdLogin(rs.getInt("idLogin"));
			dto.getLogin().setEmail(rs.getString("email"));
			dto.getLogin().setSenha(rs.getString("senha"));
			dto.getLogin().setNome(rs.getString("nome"));
			dto.getTipo().setIdAcesso(rs.getInt("tipolog"));
			dto.getLogin().setTentativas(rs.getInt("tentativas"));
			
			dtolist.add(dto);
		}
		stmt.close();
		close();
		return dtolist;
		
	}
	
	public List<DtoLoginAcesso> findAllEdit() throws Exception{
		open();
		stmt = con.prepareStatement("select * from v$buscaedit");
		rs = stmt.executeQuery();
		List<DtoLoginAcesso> login = new ArrayList<DtoLoginAcesso>();
		while (rs.next()) {
			DtoLoginAcesso lg = new DtoLoginAcesso();
			Login log = new Login(rs.getString(1),rs.getString(2),rs.getString(3));
			Acesso tip = new Acesso(null, rs.getString(4));
			lg.setLogin(log);
			lg.setTipo(tip);
			login.add(lg);
		}
		stmt.close();
		close();
		return login;
	}
	
	public void update (Login l, Acesso a) throws Exception{
		criptografia(l);
		open();
		stmt = con.prepareStatement("update login set email = ?, senha = ?, nome = ?, tipolog =? where idlogin=?");
		stmt.setString(1, l.getEmail());
		stmt.setString(2, l.getSenha());
		stmt.setString(3, l.getNome());
		stmt.setInt(4, a.getIdAcesso());
		stmt.setInt(5, l.getIdLogin());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public void updateSenha (Login l) throws Exception{
		criptografia(l);
		open();
		stmt = con.prepareStatement("update login set tentativas=0, senha =? where idlogin=?");
		stmt.setString(1, l.getSenha());
		stmt.setInt(2, l.getIdLogin());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public void delete (Integer cod) throws Exception{
		open();
		stmt = con.prepareStatement("delete from login where idlogin=?");
		stmt.setInt(1, cod);
		stmt.execute();
		stmt.close();
		close();
	}
	
	
	public static void main(String[] args) {
		
		try {
			Login log= new Login(null,"coti@gmail.com","123","coti",null);
			Acesso tip = new Acesso(4,null);
			new LoginDao().create(log,tip);
			System.out.println("Dados Gravados");
			
//			Login log= new Login(null,"jose@ig.com",null,null,null);
//			System.out.println(new LoginDao().buscarLogin("jose@ig.com"));
			
//			System.out.println( new LoginDao().findAll());
//			System.out.println( new LoginDao().findAllEdit());
//			System.out.println( new LoginDao().findByType(2));
			
//			LoginDao lg = new LoginDao();
//			System.out.println(lg.logar("joao@ig.com.br", "123"));
			
//			LoginDao lg = new LoginDao();
//			System.out.println(lg.validar("vinicius@ig.com","123"));
			
//			Login log = new Login(1, "joao@ig.com.br","123" ,"joao","usuario",null);
//			LoginDao lg = new LoginDao();
//			lg.update(log);
//			System.out.println("Alteração feita");
			
//			LoginDao lg = new LoginDao();
//			lg.delete(8);
//			System.out.println("Dados apagados");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
