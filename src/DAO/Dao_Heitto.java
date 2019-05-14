package DAO;


import java.sql.SQLException;
import java.util.ArrayList;

import Model.Heitto;
import Model.Kisa;
import Model.Osallistuja;
import Model.Pelaaja;


public class Dao_Heitto extends Dao{

	public boolean lisaaHeitot(ArrayList<Heitto> heitot){
		boolean paluuArvo=true;
		sql="INSERT INTO FG_Heittoja(Osallistuja_id, Vayla_id, lkm) VALUES(?, ?, ?)";						  
		try {
			for(Heitto heitto : heitot) {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, heitto.getOsallistuja().getOsallistujaId());
			stmtPrep.setInt(2, heitto.getVayla().getVaylaId());
			stmtPrep.setInt(3, heitto.getLkm());
			stmtPrep.executeUpdate();
	        con.close();
	        }
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
			
		}
		return paluuArvo;
	}
	
	public ArrayList<Heitto> haeHeitot(int osallistujaid) throws Exception{
		ArrayList<Heitto> heitot = new ArrayList<Heitto>();
		sql="SELECT * FROM FG_Heittoja WHERE Osallistuja_id = ?";						  
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql);
				stmtPrep.setInt(1, osallistujaid);			
	    		rs = stmtPrep.executeQuery();
	    		if(rs!=null){ 						
					while(rs.next()){
						Dao_Vayla daovayla = new Dao_Vayla();
						Dao_Osallistuja daoosa = new Dao_Osallistuja();
						Heitto heitto = new Heitto();
						heitto.setHeittoId(rs.getInt("Heitto_id"));
						heitto.setOsallistuja(daoosa.haeOsallistuja(osallistujaid));
						heitto.setVayla(daovayla.haeVayla(rs.getInt("Vayla_id")));
						heitto.setLkm(rs.getInt("lkm"));
						heitot.add(heitto);
					}					
				}
			}
			
			
			con.close();
					
		return heitot;
	}
}
