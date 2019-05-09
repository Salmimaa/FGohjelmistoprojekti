package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Kisa;
import Model.Kisa;


@WebServlet("/Servlet_HaeKisa")
public class Servlet_HaeKisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Servlet_HaeKisa() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao_Kisa dao = new Dao_Kisa();
		try {
			ArrayList<Kisa> kisat = dao.listaaKisat();
			request.setAttribute("kisat", kisat);		
			String jsp = "/kisat.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
