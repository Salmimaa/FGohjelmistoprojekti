<%@include file="header.jsp" %>
<%@ page import="Model.Pelaaja"%> 

<%
Pelaaja pelaaja = null;
if( request.getAttribute("pelaaja")!=null){
	pelaaja = (Pelaaja)request.getAttribute("pelaaja");	
}
%>
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
	<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">Muokkaa tietojasi!</h1>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
          <form action="Servlet_MuokkaaPelaaja" method="post" id="muokkaa">
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
                <input name="etunimi" id="etunimi" type="text" class="form-control form-control-lg" value="<%out.print(pelaaja.getEtunimi());%>">
                <input name="sukunimi" id="sukunimi" type="text" class="form-control form-control-lg" value="<%out.print(pelaaja.getSukunimi());%>">
                <input disabled  id="kayttajanimi" type="text" class="form-control form-control-lg" value="<%out.print(pelaaja.getKayttajanimi());%>">
                <span id="kayttajainfo"></span>
                <input name="salasana" id="salasana" type="password" class="form-control form-control-lg" placeholder="Salasana">
                <button type="submit" class="btn btn-block btn-lg btn-primary">Muuta!</button>
              </div>
       		</div>
       		<%
			if(request.getParameter("muutos")!=null){
				if(request.getParameter("muutos").equals("1")){
					out.print("Tietojen muuttaminen onnistui!");
				}
			}
       		if(request.getParameter("muutos")!=null){
				if(request.getParameter("muutos").equals("0")){
					out.print("Tietojen muuttaminen epäonnistui!");
				}
			}
			%>
			<input type="hidden" name="kayttajanimi" value="<%out.print(pelaaja.getKayttajanimi());%>">
			<input type="hidden" name="pelaajaid" value="<%out.print(pelaaja.getPelaajaId());%>">
          </form>
        </div>
      </div>
    </div>
  </header>
<script>
$(document).ready(function(){
	
	$("#rekisteroidy").validate({						
		rules: {
			etunimi:  {
				required: true,
				minlength: 2				
			},	
			sukunimi:  {
				required: true,
				minlength: 2				
			},
			
			kayttajanimi:  {
				required: true,
				minlength: 2
			},
			salasana:  {
				required: true,
				minlength: 4,
				
			}			
		},
		messages: {
			etunimi: {     
				required: "Puuttuu",
				minlength: "Liian lyhyt"			
			},
			sukunimi: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			kayttajanimi: {
				required: "Puuttuu",
				minlength: "Liian lyhyt"
			},
			salasana: {
				required: "Puuttuu",
				minlength: "Liian lyhyt",
			}	
		},			
		submitHandler: function (form) {	
			if ($("#kayttajainfo").html()!=""){
				$("#kayttajainfo").html("<label class='error'>Puuttuu</label>");
			}else{
				
				document.forms["muokkaa"].submit();
			}			
		}		
	});   
});
</script>
</body>
</html>