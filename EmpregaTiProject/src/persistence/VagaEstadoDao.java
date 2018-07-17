package persistence;



import entity.Estado;

public class VagaEstadoDao extends Dao{
	
	public void create (Estado e) throws Exception{
		open();
		stmt = con.prepareStatement("insert into vagaestado values (LAST_INSERT_ID(),?)");
		stmt.setInt(1, e.getIdEstado());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public static void main(String[] args) {
		Estado uf1 = new Estado(25);
		
		try {
			new VagaEstadoDao().create(uf1);
			System.out.println("Dado enviado ao banco");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
