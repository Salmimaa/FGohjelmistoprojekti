package DAO;

import java.util.ArrayList;

import Model.Kisa;
import Model.Postinumero;
import Model.Rata;


public class Dao_Kisa extends Dao{

	public ArrayList<Kisa> listaaKisat() throws Exception{
		Dao_Rata daorata = new Dao_Rata();
		ArrayList<Kisa> kisat = new ArrayList<Kisa>();
		sql = "SELECT * FROM FG_Kisat"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql);        		
    		rs = stmtPrep.executeQuery();   
			if(rs!=null){ 							
				while(rs.next()){
					Rata rata = new Rata();
					rata = daorata.haeRata(rs.getInt("Rata_id"));
					Kisa kisa = new Kisa();
					kisa.setKisaId(rs.getInt("Kisa_id"));
					kisa.setKisaNimi(rs.getString("Kisannimi"));
					kisa.setRata(rata);
					kisa.setAika(rs.getDate("Alkuaika"));
					kisat.add(kisa);
				}					
			}
			con.close();
		}			
		return kisat;
	}
	
	public ArrayList<Kisa> haeKisat(String hakusana) throws Exception{	
		Dao_Rata daorata = new Dao_Rata();
		ArrayList<Kisa> kisat = new ArrayList<Kisa>();
		sql = "SELECT * FROM FG_Kisat WHERE (Kisannimi LIKE ?)"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, "%"+hakusana+"%");
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ 								
				while(rs.next()){
					Rata rata = daorata.haeRata(rs.getInt("Rata_id"));
					Kisa kisa = new Kisa();
					kisa.setKisaId(rs.getInt("Kisa_id"));
					kisa.setKisaNimi(rs.getString("Kisannimi"));
					kisa.setRata(rata);
					kisa.setAika(rs.getDate("Alkuaika"));
					kisat.add(kisa);
				}					
			}
			con.close();
		}			
		return kisat;
	}
}
