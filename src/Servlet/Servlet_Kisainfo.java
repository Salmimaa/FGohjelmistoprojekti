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
import DAO.Dao_Osallistuja;
import Model.Kisa;
import Model.Osallistuja;

@WebServlet("/Servlet_Kisainfo")
public class Servlet_Kisainfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Servlet_Kisainfo() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("kisa"));
		Dao_Kisa dao = new Dao_Kisa();
		try {
			Kisa kisa = dao.haeKisa(id);
			request.setAttribute("kisa", kisa);	
			
			Dao_Osallistuja daoosa = new Dao_Osallistuja();
			ArrayList<Osallistuja> osallistujat = daoosa.listaaOsallistujat(id);
			request.setAttribute("osallistujat", osallistujat);	
			
			String jsp = "/kisainfo.jsp"; 
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