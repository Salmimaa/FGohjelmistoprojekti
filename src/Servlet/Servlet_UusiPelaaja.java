package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Pelaaja;
import Model.Pelaaja;


@WebServlet("/Servlet_UusiPelaaja")
public class Servlet_UusiPelaaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_UusiPelaaja() {
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
		
		Dao_Pelaaja dao = new Dao_Pelaaja();
		if(dao.lisaaPelaaja(pelaaja)){
			response.sendRedirect("kirjaudu.jsp?ok=1");
			
		}else{
			response.sendRedirect("rekisteroidy.jsp?ok=0");
		}
		doGet(request, response);
		
	}

}
