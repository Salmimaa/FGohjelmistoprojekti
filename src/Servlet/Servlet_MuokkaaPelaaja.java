package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Dao_Pelaaja;

/**
 * Servlet implementation class Servlet_MuokkaaPelaaja
 */
@WebServlet("/Servlet_MuokkaaPelaaja")
public class Servlet_MuokkaaPelaaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Servlet_MuokkaaPelaaja() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Dao_Pelaaja dao = new Dao_Pelaaja();
		int id = Integer.parseInt((String) session.getAttribute("id"));
		System.out.print(id);
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
