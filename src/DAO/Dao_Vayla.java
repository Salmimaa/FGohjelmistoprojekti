package DAO;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Vayla;

public class Dao_Vayla extends Dao{

	public boolean lisaaVaylat(ArrayList<Vayla> vaylat, int id){
		boolean paluuArvo=true;
		ArrayList<Vayla> vaylatid = new ArrayList<Vayla>();
		sql="INSERT INTO FG_Vaylat(Par) VALUES(?)";						  
		try {
			for(Vayla vayla : vaylat) {
			Vayla vaylaid = new Vayla();
			con = yhdista();
			stmtPrep=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			stmtPrep.setInt(1, vayla.getPar());
			stmtPrep.executeUpdate();
	        con.close();
	        ResultSet rs = stmtPrep.getGeneratedKeys();
	        	if(rs.next()) {
	        		int lastId = rs.getInt(1);
	        		vaylaid.setPar(vayla.getPar());
	        		vaylaid.setVaylaId(lastId);
	        		vaylatid.add(vaylaid);
	        	}
	        }
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
			
		}				
		
		sql="INSERT INTO FG_Ratavaylat(Rata_id, Vayla_id) VALUES(?,?)";						  
		try {
			for(Vayla vayla1 : vaylatid) {
				con = yhdista();
				stmtPrep=con.prepareStatement(sql); 
				stmtPrep.setInt(1, id);
				stmtPrep.setInt(2, vayla1.getVaylaId());
				stmtPrep.executeUpdate();
				con.close();
	        }
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	
	public ArrayList<Vayla> haeVaylat(int rataid) throws Exception{
		ArrayList<Integer> vaylaidt = new ArrayList<Integer>();
		ArrayList<Vayla> vaylat = new ArrayList<Vayla>();
		sql = "select * from FG_Ratavaylat where Rata_id = ?"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setInt(1, rataid);
    		rs = stmtPrep.executeQuery();
   
				while(rs.next()){
				vaylaidt.add(rs.getInt("Vayla_id"));
				}
				
		sql = "select * from FG_Vaylat where Vayla_id = ?"; 		
		stmtPrep = con.prepareStatement(sql);
		
		for(int i = 0; i < vaylaidt.size(); i++) {
			stmtPrep.setInt(1, (int) vaylaidt.get(i));
			rs = stmtPrep.executeQuery();
			if(rs.next()) {
				Vayla vayla = new Vayla();
				vayla.setVaylaId(rs.getInt("Vayla_id"));
				vayla.setPar(rs.getInt("par"));
				vaylat.add(vayla);
			}
		}
			con.close();
		}			
		return vaylat;
	}
	
	public Vayla haeVayla(int vaylaid) throws Exception {
		Vayla vayla = new Vayla();
		sql = "select * from FG_Vaylat where Vayla_id = ?"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setInt(1, vaylaid);
    		rs = stmtPrep.executeQuery();
    			while(rs.next()){
				vayla.setVaylaId(vaylaid);
				vayla.setPar(rs.getInt("Par"));
				}
		}
		return vayla;
	
}
}
