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
import DAO.Dao_Rata;
import Model.Kisa;
import Model.Rata;

@WebServlet("/Servlet_HaeKisat")
public class Servlet_HaeKisat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_HaeKisat() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Kisa> kisat = new ArrayList<Kisa>();
		String hakusana = request.getParameter("hakusana");
		Dao_Kisa dao = new Dao_Kisa();
		try {
			kisat = dao.haeKisat(hakusana);
			request.setAttribute("kisat", kisat);		
			String jsp = "/kisat.jsp"; 
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
