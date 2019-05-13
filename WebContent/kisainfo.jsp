<%@include file="header.jsp" %>
<%@ page import="Model.Rata"%>  
<%@ page import="Model.Kisa"%> 
<%@ page import="Model.Pelaaja"%> 
<%@ page import="Model.Osallistuja"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="Model.Postinumero"%>  
<%@ page import="java.util.ArrayList"%>  

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
%>
	<legend>Kisa: <%out.print(kisa.getKisaNimi()+" "+kisa.getAika()+" "+rata.getRadanNimi());%></legend>	
</fieldset>
<h2>Osallistujat</h2>
<table id="info" class="table">
		<thead>
			<tr>
				<th>Käyttäjä:</th>
				<th>Nimi:</th>
				<th></th>			
			</tr>
		</thead>
		<tbody>
		<%
		if(request.getAttribute("osallistujat")!=null){	
			ArrayList<Osallistuja> osallistujat = (ArrayList<Osallistuja>)request.getAttribute("osallistujat");
			
			for(Osallistuja osa : osallistujat){
				Pelaaja pelaaja = osa.getPelaaja();
				out.print("\n<tr>");
				out.print("<td class='pelaaja' id='"+pelaaja.getPelaajaId()+"'><u>" + pelaaja.getKayttajanimi() + "</u></td>");
				out.print("<td>" + pelaaja.getEtunimi() +" "+ pelaaja.getSukunimi() +"</td>");
				out.print("<td>");
				out.print("</td>");
				out.print("</tr>");
			}	
		}
		
		
		%>
		</tbody>
	</table>
	<a class="btn btn-primary text-white" href="Servlet_Osallistu?pelaaja=<%out.print(session.getAttribute("id"));%>&kisa=<% out.print(kisa.getKisaId()); %>">Osallistu</a>
	<%
	if(request.getParameter("ok")!=null){
			if(request.getParameter("ok").equals("0")){
				out.print("Olet jo kisassa!!");
			}
		}
	%>
</header>

</body>
</html>
