package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Postinumero;
import DAO.Dao_Rata;
import Model.Postinumero;
import Model.Rata;

@WebServlet("/Servlet_UusiRata")
public class Servlet_UusiRata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Servlet_UusiRata() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("uusirata.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Rata rata = new Rata();
		Postinumero posti = new Postinumero();
		Dao_Postinumero daoposti = new Dao_Postinumero();
		Dao_Rata daorata = new Dao_Rata();
		String numero = request.getParameter("postinumero");
		Postinumero paikka;
		try {
			paikka = daoposti.etsiPostitoimi(numero);
			posti.setPostinumero(numero);
			posti.setPostitoimipaikka(paikka.getPostitoimipaikka());
			rata.setRadanNimi(request.getParameter("ratanimi"));
			rata.setOsoite(request.getParameter("osoite"));
			rata.setPostinumero(posti);
			rata.setVaylanmaara(Integer.parseInt(request.getParameter("vaylamaara")));
			int id = daorata.lisaaRata(rata);
			if(id != 0) {
				
				Rata rata1 = daorata.haeRata(id);
				request.setAttribute("rata1", rata1);		
				String jsp = "/uusivaylat.jsp"; 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
				dispatcher.forward(request, response);	
				
	
			}else {
				response.sendRedirect("uusirata.jsp?ok=0");
			}
			
			doGet(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
