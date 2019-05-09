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
import DAO.Dao_Vayla;
import Model.Rata;
import Model.Vayla;


@WebServlet("/Servlet_UusiVayla")
public class Servlet_UusiVayla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Servlet_UusiVayla() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("rataid"));
		int count = Integer.parseInt(request.getParameter("count"));
		Dao_Vayla daovayla = new Dao_Vayla();
		ArrayList<Vayla> vaylat = new ArrayList<Vayla>();
		for(int i = 1; i <= count; i++) {
			Vayla vayla = new Vayla();
			int par = Integer.parseInt(request.getParameter("vaylanro"+i));
			vayla.setPar(par);
			vaylat.add(vayla);
		}
		if(daovayla.lisaaVaylat(vaylat, id)) {
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
		}else {
			response.sendRedirect("uusirata.jsp?vaylaok=0");
		}
		
		doGet(request, response);
	}

}
