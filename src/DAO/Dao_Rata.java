package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Pelaaja;
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
	
	public int lisaaRata(Rata rata){
		sql="INSERT INTO FG_Radat(Radannimi, Osoite, Postinumero, Vaylanmaara) VALUES(?,?,?,?)";
		Postinumero posti = rata.getPostinumero();
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			stmtPrep.setString(1, rata.getRadanNimi());
			stmtPrep.setString(2, rata.getOsoite());
			stmtPrep.setString(3, posti.getPostinumero());
			stmtPrep.setInt(4, rata.getVaylanmaara());
			stmtPrep.executeUpdate();
	        con.close();
	        ResultSet rs = stmtPrep.getGeneratedKeys();
	        if(rs.next()) {
	        	int lastId = rs.getInt(1);
	        	return lastId;
	        }
		} catch (Exception e) {				
			e.printStackTrace();
			
		}				
		return 0;
	}

}
