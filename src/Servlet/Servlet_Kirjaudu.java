package Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Pelaaja;
import Model.Pelaaja;

@WebServlet("/Servlet_Kirjaudu")
public class Servlet_Kirjaudu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_Kirjaudu() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao_Pelaaja dao = new Dao_Pelaaja();
		String salasana = request.getParameter("salasana");
		try {
			Pelaaja pelaaja = dao.haeKayttaja(request.getParameter("kayttajanimi"));
			if(pelaaja.getSalasana().equals(salasana)) {
				response.sendRedirect("index1.jsp?ok=1");
			}else {
				response.sendRedirect("kirjaudu.jsp?salasana=0");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		doGet(request, response);
	}

}
