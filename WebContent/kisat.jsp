<%@include file="header.jsp" %>
<%@ page import="Model.Rata"%>  
<%@ page import="Model.Kisa"%> 
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
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
	<input type="button" value="Etsi" id="haeKisa">
</fieldset>
<table id="info" class="table">
		<thead>
			<tr>
				<th>Kisan nimi:</th>
				<th>Radalla:</th>
				<th>P‰iv‰m‰‰r‰:</th>	
				<th></th>			
			</tr>
		</thead>
		<tbody>
		<%
		if(request.getAttribute("kisat")!=null){	
			ArrayList<Kisa> kisat = (ArrayList<Kisa>)request.getAttribute("kisat");
			
			for(int i=0;i<kisat.size();i++){
				Rata rata = new Rata();
				rata = kisat.get(i).getRata();
				String kisa = rata.getRadanNimi();
				out.print("\n<tr>");
				out.print("<td class='kisa_id' id='id_"+kisat.get(i).getKisaId()+"'><u>" + kisat.get(i).getKisaNimi() + "</u></td>");
				out.print("<td>" + kisa +"</td>");
				out.print("<td>" + kisat.get(i).getAika()+ "</td>");
				out.print("<td>");
				out.print("<a href='Servlet_Kisainfo?kisa="+kisat.get(i).getKisaId()+"' class='btn btn-primary text-white'>Info</a>");
				out.print("</td>");
				out.print("</tr>");
			}	
		}
		%>
		</tbody>
	</table>
<input type="button" value="Lis‰‰ Kisa" id="lisaaKisa" class="btn btn-primary">

<%
			if(request.getParameter("ok")!=null){
				if(request.getParameter("ok").equals("1")){
					out.print("Rekisterˆinti Onnistui!");
				}
			}
       		if(request.getParameter("salasana")!=null){
				if(request.getParameter("salasana").equals("0")){
					out.print("V‰‰r‰ salasana!");
				}
			}
			%>
</header>
</body>
</html>
<script>
$("#haeKisa").click(function(){
	document.location=encodeURI("Servlet_HaeKisat?hakusana=" + $("#hakuSana").val());	
});

$("#lisaaKisa").click(function(){	
	document.location="Servlet_UusiKisa";	
});
$("#muokkaa").click(function(){	
	document.location="Servlet_MuokkaaPelaaja?pelaaja=" + $(session.getAttribute("id"));	
});
</script>