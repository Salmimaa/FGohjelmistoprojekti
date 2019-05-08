package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Vayla vayla = new Vayla();
		doGet(request, response);
	}

}
