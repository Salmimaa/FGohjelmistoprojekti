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
	
	
	
}
