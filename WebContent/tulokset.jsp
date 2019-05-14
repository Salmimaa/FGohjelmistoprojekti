<%@include file="header.jsp" %>
<%@ page import="Model.Rata"%> 
<%@ page import="Model.Tulos"%>  
<%@ page import="Model.Kisa"%> 
<%@ page import="Model.Pelaaja"%> 
<%@ page import="Model.Osallistuja"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="Model.Postinumero"%>  
<%@ page import="java.util.ArrayList"%> 
<%! @SuppressWarnings("unchecked") %> 

<!-- Navigation -->
  <nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      <a class="navbar-brand" onclick="document.location='index1.jsp'">FrisbeeGolf</a>
      <%
out.print(session.getAttribute("name"));
    
%>
     <div class="left">
      <a class="btn btn-primary text-white" href="Servlet_Kirjaudu?out=1">Kirjaudu Ulos</a>
     <a class="btn btn-primary text-white" href="Servlet_MuokkaaPelaaja">Muokkaa tietoja</a>
  	 </div>
 	</div>
  </nav>
<!-- Masthead -->
  <header class="masthead">
<fieldset id="info">
<% 
Kisa kisa = new Kisa();
kisa = (Kisa)request.getAttribute("kisa"); 
Rata rata = new Rata();
rata = kisa.getRata();
ArrayList<Tulos> tulokset = new ArrayList<Tulos>();
tulokset = (ArrayList<Tulos>)request.getAttribute("tulokset");

%>
	<legend>Kisa: <%out.print(kisa.getKisaNimi()+" "+kisa.getAika()+" "+rata.getRadanNimi());%></legend>
	
	<a class="btn btn-primary text-white" href="Servlet_Pelaa?pelaaja=<%out.print(session.getAttribute("id"));%>&kisa=<% out.print(kisa.getKisaId()); %>">Pelaa!</a>
	<a class="btn btn-primary text-white" href="Servlet_Tulokset?kisa=<% out.print(kisa.getKisaId()); %>">Tulokset!</a>
</fieldset>
<h2>Osallistujat</h2>
<table id="info" class="table">
		<thead>
			<tr>
				<th>Käyttäjä:</th>
				<th>Nimi:</th>
				<th>Tulos:</th>			
			</tr>
		</thead>
		<tbody>
		<%
			
			for(Tulos tulos : tulokset){
				Osallistuja osallistuja = tulos.getOsallistuja();
				Pelaaja pelaaja = osallistuja.getPelaaja();
				int tulo = tulos.getTulos();
				out.print("\n<tr>");
				out.print("<td class='pelaaja' id='"+pelaaja.getPelaajaId()+"'><u>" + pelaaja.getKayttajanimi() + "</u></td>");
				out.print("<td>" + pelaaja.getEtunimi() +" "+ pelaaja.getSukunimi() +"</td>");
				out.print("<td  id='"+osallistuja.getOsallistujaId()+"'><u>" + tulo + "</u></td>");
				out.print("</tr>");
			}	

		%>
		</tbody>
	</table>
	<a class="btn btn-primary text-white" href="Servlet_Osallistu?pelaaja=<%out.print(session.getAttribute("id"));%>&kisa=<% out.print(kisa.getKisaId()); %>">Osallistu</a>

</header>

</body>
</html>
