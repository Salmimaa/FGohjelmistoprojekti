package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Rata;
import Model.Rata;

/**
 * Servlet implementation class Servlet_HaeRata
 */
@WebServlet("/Servlet_HaeRata")
public class Servlet_HaeRata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_HaeRata() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Rata> radat = new ArrayList<Rata>();
		String hakusana = request.getParameter("hakusana");
		Dao_Rata dao = new Dao_Rata();
		try {
			radat = dao.haeRadat(hakusana);
			request.setAttribute("radat", radat);		
			String jsp = "/radat.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
