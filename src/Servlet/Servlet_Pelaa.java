package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Dao_Heitto;
import DAO.Dao_Kisa;
import DAO.Dao_Osallistuja;
import DAO.Dao_Pelaaja;
import DAO.Dao_Vayla;
import Model.Heitto;
import Model.Kisa;
import Model.Osallistuja;
import Model.Pelaaja;
import Model.Ratavayla;
import Model.Vayla;

@WebServlet("/Servlet_Pelaa")
public class Servlet_Pelaa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet_Pelaa() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao_Pelaaja daopelaaja = new Dao_Pelaaja();
		Dao_Kisa daokisa = new Dao_Kisa();
		Dao_Osallistuja daoosa = new Dao_Osallistuja();
		Dao_Vayla daovayla = new Dao_Vayla();
		
		try {
			Pelaaja pelaaja = daopelaaja.haePelaaja(Integer.parseInt(request.getParameter("pelaaja")));
			Kisa kisa = daokisa.haeKisa(Integer.parseInt(request.getParameter("kisa")));
			Osallistuja osallistuja = daoosa.osallistujaPelaa(pelaaja, kisa);
			ArrayList<Vayla> vaylat = new ArrayList<Vayla>();
			vaylat = daovayla.haeVaylat(kisa.getRata().getRataId());
			request.setAttribute("osallistuja", osallistuja);
			request.setAttribute("vaylat", vaylat);
			request.setAttribute("kisa", kisa);
			String jsp = "/pelaa.jsp"; 
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Dao_Pelaaja daopelaaja = new Dao_Pelaaja();
		Dao_Kisa daokisa = new Dao_Kisa();
		Dao_Osallistuja daoosa = new Dao_Osallistuja();
		Dao_Vayla daovayla = new Dao_Vayla();
		Dao_Heitto daoheitto = new Dao_Heitto();
		
		int osallistujaid = Integer.parseInt(request.getParameter("osallistujaid"));
		int count = Integer.parseInt(request.getParameter("count"));
		ArrayList<Vayla> vaylat = new ArrayList<Vayla>();
		Kisa kisa;
		try {
			kisa = daokisa.haeKisa(Integer.parseInt(request.getParameter("kisa")));
			vaylat = daovayla.haeVaylat(kisa.getRata().getRataId());
			ArrayList<Heitto> heitot = new ArrayList<Heitto>();

			Osallistuja osal = new Osallistuja();
			osal.setKisa(kisa);
			osal.setOsallistujaId(osallistujaid);
			int pelaaja1 = (int) session.getAttribute("id");
			osal.setPelaaja(daopelaaja.haePelaaja(pelaaja1));
					
			int k = 0;
			for(int i = 1; i < count; i++) {
				int lkm = Integer.parseInt(request.getParameter("heitto"+i));
				Vayla v = vaylat.get(k);
				Heitto heitto = new Heitto();
				heitto.setLkm(lkm);
				heitto.setOsallistuja(osal);
				heitto.setVayla(v);
				heitot.add(heitto);
				k++;

			}
			if(daoheitto.lisaaHeitot(heitot)) {
				request.setAttribute("kisa", kisa);	
	
				ArrayList<Osallistuja> osallistujat = daoosa.listaaOsallistujat(kisa.getKisaId());
				request.setAttribute("osallistujat", osallistujat);	
				
				String jsp = "/kisainfo.jsp"; 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
				dispatcher.forward(request, response);			
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
