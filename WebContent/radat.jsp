<%@include file="header.jsp" %>
<%@ page import="Model.Rata"%>  
<%@ page import="Model.Postinumero"%>  
<%@ page import="java.util.ArrayList"%>  
<%! @SuppressWarnings("unchecked") %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      <a class="navbar-brand" onclick="document.location='index1.jsp'">FrisbeeGolf</a>
            <%
out.print(session.getAttribute("name"));
            out.print(session.getAttribute("id"));
%>
<div class="left">
      <a class="btn btn-primary text-white" href="Servlet_Kirjaudu?out=1">Kirjaudu Ulos</a>
       <a class="btn btn-primary text-white" href="Servlet_MuokkaaPelaaja">Muokkaa tietoja</a>
   </div>
 	</div>
  </nav>
 <header class="masthead">
<fieldset id="haku">
	<legend>Hae:</legend>	
	<input type="text" name="hakuSana" id="hakuSana" value="">
	<input type="button" value="Etsi" id="haeRata">
</fieldset>
<table id="info" class="table">
		<thead>
			<tr>
				<th>Radan nimi:</th>
				<th>Osoite:</th>
				<th>V‰yl‰m‰‰r‰:</th>	
				<th></th>			
			</tr>
		</thead>
		<tbody>
		<%
		if(request.getAttribute("radat")!=null){	
			ArrayList<Rata> radat = (ArrayList<Rata>)request.getAttribute("radat");
			Postinumero postinumero = new Postinumero();
			
			for(int i=0;i<radat.size();i++){
				postinumero = radat.get(i).getPostinumero();
				String posti = postinumero.getPostinumero();
				String paikka = postinumero.getPostitoimipaikka();
				out.print("\n<tr>");
				out.print("<td class='rata_id' id='id_"+radat.get(i).getRataId()+"'><u>" + radat.get(i).getRadanNimi() + "</u></td>");
				out.print("<td>" + radat.get(i).getOsoite() +" "+ posti +" "+ paikka +"</td>");
				out.print("<td>" + radat.get(i).getVaylanmaara()+ "</td>");	
				out.print("<td>");
				out.print("\n<input type='button' class='btn btn-primary text-white' id='muokkaa_"+radat.get(i).getRataId()+"' name='"+radat.get(i).getRadanNimi()+" "+radat.get(i).getRataId()+"' title='Muokkaa' value='Muokkaa'>");
				out.print("</td>");
				out.print("</tr>");
			}	
		}
		%>
		</tbody>
	</table>
<input type="button" value="Lis‰‰ Rata" id="lisaaRata" class="btn btn-primary">
</header>
</body>
</html>
<script>
$("#haeRata").click(function(){
	document.location=encodeURI("Servlet_HaeRata?hakusana=" + $("#hakuSana").val());	
});
$(".muokkaa").click(function(){	
	document.location="Servlet_MuokkaaRata?Rata_id=" + $(this)[0].id;	
});
$("#lisaaRata").click(function(){	
	document.location="Servlet_UusiRata";	
});
$("#muokkaa").click(function(){	
	document.location="Servlet_MuokkaaPelaaja?pelaaja=" + $(session.getAttribute("id"));	
});
</script>