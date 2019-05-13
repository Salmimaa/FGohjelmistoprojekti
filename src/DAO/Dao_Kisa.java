package DAO;


import java.util.ArrayList;

import Model.Kisa;
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
	
	public boolean lisaaKisa(Kisa kisa){
		sql="INSERT INTO FG_Kisat(Kisannimi, Rata_id, Alkuaika) VALUES(?,?,?)";
		Rata rata = kisa.getRata();
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, kisa.getKisaNimi());
			stmtPrep.setInt(2, rata.getRataId());
			stmtPrep.setDate(3, new java.sql.Date(kisa.getAika().getTime()));
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			return false;
			
		}				
		return true;
	}
	
	public Kisa haeKisa(int id) throws Exception{
		Dao_Rata daorata = new Dao_Rata();
		Kisa kisa = new Kisa();
		sql = "SELECT * FROM FG_Kisat WHERE Kisa_id = ?"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql);
			stmtPrep.setInt(1, id);
			rs = stmtPrep.executeQuery();   
			if(rs!=null){ 							
				while(rs.next()){
					Rata rata = new Rata();
					rata = daorata.haeRata(rs.getInt("Rata_id"));
					kisa.setKisaId(rs.getInt("Kisa_id"));
					kisa.setKisaNimi(rs.getString("Kisannimi"));
					kisa.setRata(rata);
					kisa.setAika(rs.getDate("Alkuaika"));
				}					
			}
			con.close();
		}			
		return kisa;
	}
}
