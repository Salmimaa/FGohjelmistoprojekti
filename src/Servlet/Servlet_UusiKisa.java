package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

@WebServlet("/Servlet_UusiKisa")
public class Servlet_UusiKisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet_UusiKisa() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao_Rata daorata = new Dao_Rata();
		ArrayList<Rata> radat = new ArrayList<Rata>();
		try {
			radat = daorata.listaaRadat();
			request.setAttribute("radat", radat);		
			String jsp = "/uusikisa.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
		Dao_Kisa daokisa = new Dao_Kisa();
		Dao_Rata daorata = new Dao_Rata();
		Kisa kisa = new Kisa();
		kisa.setKisaNimi(request.getParameter("kisannimi"));
		System.out.print(request.getParameter("rata"));
		System.out.print(request.getParameter("kisannimi"));
		System.out.print(request.getParameter("paiva"));
		int id = Integer.parseInt(request.getParameter("rata"));
		try {
			kisa.setRata(daorata.haeRata(id));
			Date paiva;
			paiva = formatter1.parse(request.getParameter("paiva"));
			kisa.setAika(paiva);
			if(daokisa.lisaaKisa(kisa)) {
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
			}else {
				response.sendRedirect("uusikisa.jsp");
			}
		} catch (ParseException e) {
			System.out.print("ei p‰iv‰‰");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
