package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pelaaja pelaaja = new Pelaaja();
		pelaaja.setEtunimi(request.getParameter("etunimi"));
		pelaaja.setSukunimi(request.getParameter("sukunimi"));
		pelaaja.setKayttajanimi(request.getParameter("kayttajanimi"));
		pelaaja.setSalasana(request.getParameter("salasana"));
		doGet(request, response);
	}

}
