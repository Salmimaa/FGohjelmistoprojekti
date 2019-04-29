package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Pelaaja;

@WebServlet("/Servlet_Kayttaja_Ajax")
public class Servlet_Kayttaja_Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet_Kayttaja_Ajax() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kayttaja = request.getParameter("kayttajanimi");
		Dao_Pelaaja dao = new Dao_Pelaaja();
		try {
			if(dao.haeKayttaja(kayttaja) != null) {
				PrintWriter out = response.getWriter();
			    response.setContentType("text/html"); 		
			    out.println("Käyttäjänimi on jo käytössä!");		    
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
