<%@include file="header.jsp" %>
<%@ page import="Model.Rata"%>  
<%@ page import="Model.Kisa"%> 
<%@ page import="Model.Pelaaja"%> 
<%@ page import="Model.Osallistuja"%>
<%@ page import="Model.Vayla"%>
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
      Osallistuja osallistuja = null;
      if( request.getAttribute("osallistuja")!=null){
      	osallistuja = (Osallistuja)request.getAttribute("osallistuja");	
      }
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
<h2>Pelaa!</h2>
<div class="container">
<form action="Servlet_Pelaa" method="post" id="pelaa">
<table id="info" class="table">
		<thead>
			<tr>
				<th>Väylä:</th>
				<th>Par:</th>
				<th>Heitto:</th>			
			</tr>
		</thead>
		<tbody>
		<%
		int count = 1;
		if(request.getAttribute("vaylat")!=null){	
			ArrayList<Vayla> vaylat = (ArrayList<Vayla>)request.getAttribute("vaylat");
			
			for(Vayla vayla : vaylat){
				out.print("\n<tr>");
				out.print("<td id='vayla"+count+"'><u>Vayla " + count + "</u></td>");
				out.print("<td>" + vayla.getPar() +"</td>");
				out.print("<td>");
				out.print("<input name='heitto"+count+"' id='heitto"+count+"' type='text' class='form-control form-control-lg' placeholder='Heittojen lkm'>");
				out.print("</td>");
				out.print("</tr>");

				count++;
			}	
		}
		
		
		%>
		
		</tbody>
	</table>
	<input type="hidden" name="count" value="<%out.print(count);%>">
	<input type="hidden" name="kisa" value="<%out.print(kisa.getKisaId());%>">
	<input type="hidden" name="osallistujaid" value="<%out.print(osallistuja.getOsallistujaId());%>">
	<button type="submit" class="btn btn-block btn-lg btn-primary">Valmis!</button>
</form>
</div>
</header>

</body>
</html>
