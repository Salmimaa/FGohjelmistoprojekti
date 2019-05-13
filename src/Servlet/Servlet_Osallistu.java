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
import DAO.Dao_Pelaaja;
import Model.Kisa;
import Model.Osallistuja;
import Model.Pelaaja;

@WebServlet("/Servlet_Osallistu")
public class Servlet_Osallistu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet_Osallistu() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao_Pelaaja daopelaaja = new Dao_Pelaaja();
		Dao_Kisa daokisa = new Dao_Kisa();
		Dao_Osallistuja daoosa = new Dao_Osallistuja();
		Pelaaja pelaaja = new Pelaaja();
		Kisa kisa = new Kisa();
		try {
			pelaaja = daopelaaja.haePelaaja(Integer.parseInt(request.getParameter("pelaaja")));
			kisa = daokisa.haeKisa(Integer.parseInt(request.getParameter("kisa")));
			
			if(daoosa.etsiOsallistuja(pelaaja, kisa)) {
				
		
			if(daoosa.osallistuKisaan(pelaaja, kisa)) {
				request.setAttribute("kisa", kisa);	
	
				ArrayList<Osallistuja> osallistujat = daoosa.listaaOsallistujat(kisa.getKisaId());
				request.setAttribute("osallistujat", osallistujat);	
				
				String jsp = "/kisainfo.jsp"; 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
				dispatcher.forward(request, response);		
			}else {
				System.out.print("Ei käy");
			}
			}else {
				request.setAttribute("kisa", kisa);	
				
				ArrayList<Osallistuja> osallistujat = daoosa.listaaOsallistujat(kisa.getKisaId());
				request.setAttribute("osallistujat", osallistujat);	
				request.setAttribute("ok", 0);
				
				String jsp = "/kisainfo.jsp"; 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
				dispatcher.forward(request, response);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
