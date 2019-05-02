package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Dao_Pelaaja;
import Model.Pelaaja;

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
		int userid = (Integer) session.getAttribute("id");
		System.out.print(userid);
		try {
			Pelaaja pelaaja = dao.haePelaaja(userid);
			request.setAttribute("pelaaja", pelaaja);		
			String jsp = "/muokkaaPelaaja.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Dao_Pelaaja dao = new Dao_Pelaaja();
		try {

				Pelaaja pelaaja = new Pelaaja();
				pelaaja.setEtunimi(request.getParameter("etunimi"));
				pelaaja.setSukunimi(request.getParameter("sukunimi"));
				
				pelaaja.setSalasana(request.getParameter("salasana"));
				pelaaja.setPelaajaId(Integer.parseInt(request.getParameter("pelaajaid")));
				
				
				if(dao.muutaPelaaja(pelaaja)){
					response.sendRedirect("index1.jsp?muutos=1");
					
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
