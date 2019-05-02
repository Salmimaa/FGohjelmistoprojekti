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


@WebServlet("/Servlet_Kirjaudu")
public class Servlet_Kirjaudu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_Kirjaudu() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String salasana = request.getParameter("salasana");	
		String kayttaja = request.getParameter("kayttajanimi");
		HttpSession session = request.getSession(true);
		Dao_Pelaaja dao = new Dao_Pelaaja();
		try {
			Pelaaja pelaaja = dao.haeKayttaja(kayttaja, salasana);
			session.setAttribute("id", pelaaja.getPelaajaId());	
			session.setAttribute("name", pelaaja.getEtunimi() + " " + pelaaja.getSukunimi());
			System.out.print(pelaaja.getPelaajaId());
			System.out.print(pelaaja.getEtunimi());
			System.out.print(pelaaja.getSukunimi());
			
			
			String jsp = "/index1.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);			   				

			
		} catch (Exception e) {			
			e.printStackTrace();
		} 
	}
	

}
