package DAO;

import java.util.ArrayList;
import Model.Postinumero;
import Model.Rata;

public class Dao_Rata extends Dao{
	
	public Rata haeRata(int rataid) throws Exception{
		Rata rata = null;
		Dao_Postinumero daoposti = new Dao_Postinumero();
		sql = "SELECT * FROM FG_Radat WHERE Rata_id=?"; 		
		con=yhdista();
		Postinumero posti = new Postinumero();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, rataid);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ 						
				while(rs.next()){
					posti.setPostinumero(rs.getString("Postinumero"));
					Postinumero uusi = daoposti.etsiPostitoimi(rs.getString("Postinumero"));
					posti.setPostitoimipaikka(uusi.getPostitoimipaikka());
					rata = new Rata();
					rata.setRataId(rs.getInt("Rata_id"));
					rata.setRadanNimi(rs.getString("Radannimi"));
					rata.setOsoite(rs.getString("Osoite"));
					rata.setPostinumero(posti);
					rata.setVaylanmaara(rs.getInt("Vaylanmaara"));
				}					
			}
			con.close();
		}			
		return rata;
	}
	
	public ArrayList<Rata> listaaRadat() throws Exception{
		Dao_Postinumero daoposti = new Dao_Postinumero();
		Postinumero posti = new Postinumero();
		ArrayList<Rata> radat = new ArrayList<Rata>();
		sql = "SELECT * FROM FG_Radat"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql);        		
    		rs = stmtPrep.executeQuery();   
			if(rs!=null){ 							
				while(rs.next()){
					posti.setPostinumero(rs.getString("Postinumero"));
					Postinumero uusi = daoposti.etsiPostitoimi(rs.getString("Postinumero"));
					posti.setPostitoimipaikka(uusi.getPostitoimipaikka());
					Rata rata = new Rata();
					rata.setRataId(rs.getInt("Rata_id"));
					rata.setRadanNimi(rs.getString("Radannimi"));
					rata.setOsoite(rs.getString("Osoite"));
					rata.setPostinumero(posti);
					rata.setVaylanmaara(rs.getInt("Vaylanmaara"));
					radat.add(rata);
				}					
			}
			con.close();
		}			
		return radat;
	}
	
	public ArrayList<Rata> haeRadat(String hakusana) throws Exception{	
		Dao_Postinumero daoposti = new Dao_Postinumero();
		Postinumero posti = new Postinumero();
		ArrayList<Rata> radat = new ArrayList<Rata>();
		sql = "SELECT * FROM FG_Radat WHERE (Radannimi LIKE ? OR Osoite LIKE ? OR Postinumero LIKE ? OR Vaylanmaara LIKE ?)"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, "%"+hakusana+"%");
			stmtPrep.setString(2, "%"+hakusana+"%");
			stmtPrep.setString(3, "%"+hakusana+"%");
			stmtPrep.setString(4, "%"+hakusana+"%");
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ 								
				while(rs.next()){
					posti.setPostinumero(rs.getString("Postinumero"));
					Postinumero uusi = daoposti.etsiPostitoimi(rs.getString("Postinumero"));
					posti.setPostitoimipaikka(uusi.getPostitoimipaikka());
					Rata rata = new Rata();
					rata.setRataId(rs.getInt("Rata_id"));
					rata.setRadanNimi(rs.getString("Radannimi"));
					rata.setOsoite(rs.getString("Osoite"));
					rata.setPostinumero(posti);
					rata.setVaylanmaara(rs.getInt("Vaylanmaara"));
					radat.add(rata);
				}					
			}
			con.close();
		}			
		return radat;
	}

}
