package DAO;

import java.util.List;

import Model.Pelaaja;
import Model.Vayla;

public class Dao_Vayla extends Dao{

	public boolean lisaaPelaaja(List<Vayla> vaylat){
		sql="INSERT INTO FG_Ratavaylat(Rata_id, Vayla_id) VALUES(?,?)";						  
		try {
			for(Vayla vayla : vaylat) {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, vayla.getEtunimi());
			stmtPrep.setString(2, pelaaja.getSukunimi());
			stmtPrep.executeUpdate();
	        con.close();
	        
			}
		} catch (Exception e) {				
			e.printStackTrace();
			
		}				
		
	}
	
	
	
}
