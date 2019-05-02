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
 * Servlet implementation class Servlet_HaeRadat
 */
@WebServlet("/Servlet_HaeRadat")
public class Servlet_HaeRadat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Servlet_HaeRadat() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Dao_Rata dao = new Dao_Rata();
			try {
				ArrayList<Rata> radat = dao.listaaRadat();
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
