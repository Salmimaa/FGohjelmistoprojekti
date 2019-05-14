package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao_Heitto;
import DAO.Dao_Kisa;
import DAO.Dao_Osallistuja;
import Model.Heitto;
import Model.Kisa;
import Model.Osallistuja;
import Model.Tulos;

/**
 * Servlet implementation class Servlet_Tulokset
 */
@WebServlet("/Servlet_Tulokset")
public class Servlet_Tulokset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet_Tulokset() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao_Kisa daokisa = new Dao_Kisa();
		Dao_Osallistuja daoosa = new Dao_Osallistuja();
		Dao_Heitto daoheitto = new Dao_Heitto();
		try {
			Kisa kisa = daokisa.haeKisa(Integer.parseInt(request.getParameter("kisa")));
			ArrayList<Osallistuja> osallistujat = daoosa.listaaOsallistujat(kisa.getKisaId());
			Osallistuja osallistuja = new Osallistuja();
			ArrayList<Tulos> tulokset = new ArrayList<Tulos>();
			for(int i = 0; i < osallistujat.size(); i++) {
				int tulos = 0;
				ArrayList<Heitto> heitot = daoheitto.haeHeitot(osallistujat.get(i).getOsallistujaId());
				for(int k = 0; k < heitot.size(); k++) {
					tulos = tulos + heitot.get(k).getLkm();
					osallistuja = heitot.get(k).getOsallistuja();
				}
				Tulos tulos1 = new Tulos();
				tulos1.setOsallistuja(osallistuja);
				tulos1.setTulos(tulos);
				tulokset.add(tulos1);
				
			}

			request.setAttribute("kisa", kisa);	
			request.setAttribute("osallistujat", osallistujat);	
			request.setAttribute("tulokset", tulokset);	
			
			
			String jsp = "/tulokset.jsp"; 
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
