<%@include file="header.jsp" %>
<%@ page import="Model.Rata"%>  
<%@ page import="Model.Kisa"%> 
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="Model.Postinumero"%>  
<%@ page import="java.util.ArrayList"%>  
<%! @SuppressWarnings("unchecked") %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
          <h1 class="mb-5">Lis‰‰ uusi Kisa!</h1>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
          <form action="Servlet_UusiKisa" method="post" id="uusikisa">
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
                <input name="kisannimi" id="kisannimi" type="text" class="form-control form-control-lg" placeholder="Kisan nimi">
                	<div class="form-group">
   						<label for="exampleFormControlSelect1"></label>
    					<select class="form-control" id="rata" name="rata">
    					<%
    					if(request.getAttribute("radat")!=null){	
    						ArrayList<Rata> radat = (ArrayList<Rata>)request.getAttribute("radat");
    							for(Rata rata : radat){
    								out.print("<option value='"+rata.getRataId()+"'>"+rata.getRadanNimi()+"</option>");
    							}
    					}
    					%>
    					</select>
  					</div>
              	<input name="paiva" id="datepicker" type="text" class="form-control form-control-lg" placeholder="P‰iv‰m‰‰r‰">
                <button type="submit" class="btn btn-block btn-lg btn-primary">Tallenna!</button>
              </div>
       		</div>
          </form>
        </div>
      </div>
    </div>
  </header>
 <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
 </script>
<script>
$(document).ready(function(){
	$("#postinumero").blur(function(){
	    $.ajax({url: "Servlet_Postinumero_Ajax?postinumero="+$("#postinumero").val(), success: function(result){
	        $("#postitoimipaikka").html(result);
	    }});
	});
	
		
	
});
</script>



</body>
</html>