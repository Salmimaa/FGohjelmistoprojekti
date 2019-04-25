package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//Dao luokalla otetaan yhteys mariaDB tietokantaan
public class Dao {
	
	public Connection con=null;
	public ResultSet rs = null;
	public PreparedStatement stmtPrep=null; 
	public String sql;
	
	public Connection yhdista() throws Exception{
    	Connection con = null;    	        	
    	String JDBCAjuri = "org.mariadb.jdbc.Driver";
    	String url = "jdbc:mariadb://localhost:15001/a1800573";        	
   	    Class.forName(JDBCAjuri);
	    con = DriverManager.getConnection(url,"a1800573", "reXIS643o");	        
	    return con;	    
	}
	
	public void sulje() throws Exception{
		if(con!=null){			
			con.close();			
		}		
	}
}
