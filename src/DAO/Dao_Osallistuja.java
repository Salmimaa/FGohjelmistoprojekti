package DAO;

import java.util.ArrayList;

import Model.Kisa;
import Model.Osallistuja;
import Model.Pelaaja;
import Model.Rata;

public class Dao_Osallistuja extends Dao{
	
	public ArrayList<Osallistuja> listaaOsallistujat(int kisaId) throws Exception{
	
		ArrayList<Osallistuja> osallistujat = new ArrayList<Osallistuja>();		
		sql = "SELECT * FROM FG_Osallistujat Where Kisa_id = ?"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, kisaId);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ 						
				while(rs.next()){
					Dao_Kisa daokisa = new Dao_Kisa();
					Dao_Pelaaja daopel = new Dao_Pelaaja();
					Kisa kisa = new Kisa();
					Pelaaja pelaaja = new Pelaaja();
					
					pelaaja = daopel.haePelaaja(rs.getInt("Pelaaja_id"));
					kisa = daokisa.haeKisa(rs.getInt("Kisa_id"));
					
					Osallistuja osallistuja = new Osallistuja();	
					osallistuja.setOsallistujaId(rs.getInt("Osallistuja_id"));
					osallistuja.setKisa(kisa);
					osallistuja.setPelaaja(pelaaja);
					
					osallistujat.add(osallistuja);
				}					
			}
			con.close();
		}			
		return osallistujat;
	}	
	
	public boolean osallistuKisaan(Pelaaja pelaaja, Kisa kisa){
		boolean paluuArvo=true;
		sql="INSERT INTO FG_Osallistujat(Pelaaja_id, Kisa_id) VALUES(?,?)";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, pelaaja.getPelaajaId());
			stmtPrep.setInt(2, kisa.getKisaId());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public boolean etsiOsallistuja(Pelaaja pelaaja, Kisa kisa){
		boolean paluuArvo=true;
		sql="SELECT * FROM FG_Osallistujat WHERE Pelaaja_id = ? AND Kisa_id = ?";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, pelaaja.getPelaajaId());
			stmtPrep.setInt(2, kisa.getKisaId());
			rs = stmtPrep.executeQuery();  
	        if(rs!=null){ 						
				while(rs.next()){
					return false;
				}
	        }else {
	        	paluuArvo=false;
	        }
	       con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}
		  
		return paluuArvo;
	}
	
	
		
}
