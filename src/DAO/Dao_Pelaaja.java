package DAO;

import Model.Pelaaja;


//pelaaja luokka joka on jatkettu Dao luokasta t��ll� on metodeja jolla voidaan lis��, poistaa ja hallinoida tietokantaa
public class Dao_Pelaaja extends Dao {
	
	public boolean lisaaPelaaja(Pelaaja pelaaja){
		boolean paluuArvo=true;
		sql="INSERT INTO FG_Pelaajat(Etunimi, Sukunimi, Kayttajanimi, Salasana) VALUES(?,?,?,?)";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, pelaaja.getEtunimi());
			stmtPrep.setString(2, pelaaja.getSukunimi());
			stmtPrep.setString(3, pelaaja.getKayttajanimi());
			stmtPrep.setString(4, pelaaja.getSalasana());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public Pelaaja haePelaaja(int pelaajaId) throws Exception{
		Pelaaja pelaaja = null;		
		sql = "SELECT * FROM FG_Pelaajat WHERE Pelaaja_id=?"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setInt(1, pelaajaId);			
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ 						
				while(rs.next()){
					pelaaja = new Pelaaja();
					pelaaja.setPelaajaId(rs.getInt("Pelaaja_id"));
					pelaaja.setEtunimi(rs.getString("Etunimi"));
					pelaaja.setSukunimi(rs.getString("Sukunimi"));
					pelaaja.setKayttajanimi(rs.getString("Kayttajanimi"));
					pelaaja.setSalasana(rs.getString("Salasana"));
				}					
			}
			con.close();
		}			
		return pelaaja;
	}
	
	public Pelaaja haeKayttaja(String kayttaja, String salasana) throws Exception{
		Pelaaja pelaaja = null;		
		sql = "SELECT * FROM FG_Pelaajat WHERE Kayttajanimi=? AND Salasana=?"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, kayttaja);
			stmtPrep.setString(2, salasana);
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ 						
				while(rs.next()){
					pelaaja = new Pelaaja();
					pelaaja.setPelaajaId(rs.getInt("Pelaaja_id"));
					pelaaja.setEtunimi(rs.getString("Etunimi"));
					pelaaja.setSukunimi(rs.getString("Sukunimi"));
					pelaaja.setKayttajanimi(rs.getString("Kayttajanimi"));
					pelaaja.setSalasana(rs.getString("Salasana"));
				}					
			}
			con.close();
		}			
		return pelaaja;
	}
	
	public Pelaaja haeKayttaja1(String kayttaja) throws Exception{
		Pelaaja pelaaja = null;		
		sql = "SELECT * FROM FG_Pelaajat WHERE Kayttajanimi=?"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, kayttaja);
    		rs = stmtPrep.executeQuery();  
			if(rs!=null){ 						
				while(rs.next()){
					pelaaja = new Pelaaja();
					pelaaja.setPelaajaId(rs.getInt("Pelaaja_id"));
					pelaaja.setEtunimi(rs.getString("Etunimi"));
					pelaaja.setSukunimi(rs.getString("Sukunimi"));
					pelaaja.setKayttajanimi(rs.getString("Kayttajanimi"));
					pelaaja.setSalasana(rs.getString("Salasana"));
				}					
			}
			con.close();
		}			
		return pelaaja;
	}
	public boolean muutaPelaaja(Pelaaja pelaaja){
		boolean paluuArvo=true;
		sql="UPDATE FG_Pelaajat SET Etunimi = ?, Sukunimi = ?, Salasana = ? WHERE Pelaaja_id = ?";	
		System.out.print(pelaaja);
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setString(1, pelaaja.getEtunimi());
			stmtPrep.setString(2, pelaaja.getSukunimi());
			stmtPrep.setString(3, pelaaja.getSalasana());
			stmtPrep.setInt(4, pelaaja.getPelaajaId());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
}
