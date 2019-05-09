<%@include file="header.jsp" %>
<%@ page import="Model.Rata"%>
<%@ page import="Model.Postinumero"%>  
<%@ page import="java.util.ArrayList"%>  
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
          <h1 class="mb-5">Lis‰‰ v‰yl‰ tiedot!</h1>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
          <form action="Servlet_UusiVayla" method="post" id="uusiVayla">
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
              
              
              	<%
              		int count = 0;
              		Rata rata = (Rata)request.getAttribute("rata1");
              	 	int vaylat = rata.getVaylanmaara();
					for(int i=1;i<=vaylat;i++){
	
							out.print("<input name='vaylanro"+i+"' id='vaylanro"+i+"' type='text' class='form-control form-control-lg' placeholder='V‰yl‰ nro"+i+"'>");
							count = count + 1;
						
				}	
		
		%>
              	<input type="hidden" name="count" value="<%out.print(count);%>">
              	<input type="hidden" name="rataid" value="<%out.print(rata.getRataId());%>">
                <button type="submit" class="btn btn-block btn-lg btn-primary">Tallenna!</button>
              </div>
       		</div>
          </form>
        </div>
      </div>
    </div>
  </header>

</body>
</html>