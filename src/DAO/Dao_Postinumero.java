package DAO;

import java.util.ArrayList;

import DAO.Dao;
import Model.Postinumero;

public class Dao_Postinumero extends Dao {
	
	public ArrayList<Postinumero> listaaKaikki() throws Exception{
		ArrayList<Postinumero> postinumerot = new ArrayList<Postinumero>();
		sql = "SELECT * FROM FG_Postinumerot"; 		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql);        		
    		rs = stmtPrep.executeQuery();   
			if(rs!=null){ 							
				while(rs.next()){
					Postinumero postinumero = new Postinumero();
					postinumero.setPostinumero(rs.getString("Postinumero"));
					postinumero.setPostitoimipaikka(rs.getString("Postitoimipaikka"));
					postinumerot.add(postinumero);
				}					
			}
			con.close();
		}			
		return postinumerot;
	}
	
	public Postinumero etsiPostitoimi(String postinumero) throws Exception{
		Postinumero numero = null;
		sql = "SELECT * FROM FG_Postinumerot WHERE Postinumero=?";		
		con=yhdista();
		if(con!=null){ 
			stmtPrep = con.prepareStatement(sql); 
			stmtPrep.setString(1, postinumero);
    		rs = stmtPrep.executeQuery();  
    		if(rs.isBeforeFirst()){ 
    			rs.next();
    			numero = new Postinumero();  
    			numero.setPostinumero(rs.getString("Postinumero"));
    			numero.setPostitoimipaikka(rs.getString("Postitoimipaikka"));      			       			
			}	
    		con.close(); 
		}			
		return numero;		
	}
}

