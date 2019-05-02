<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	 <!-- Navigation -->
  <nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      <a class="navbar-brand" onclick="document.location='index.jsp'">FrisbeeGolf</a>
    
     <div class="left">
      		<a class="btn btn-primary text-white" onclick="document.location='kirjaudu.jsp'">Kirjaudu</a>
      		<a class="btn btn-primary text-white" onclick="document.location='rekisteroidy.jsp'">Rekisteröidy</a>
 		</div>
 
    </div>
  </nav>
		<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">Kirjaudu sisään!</h1>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
          <form action="Servlet_Kirjaudu" method="post" id="kirjaudu">
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
                <input name="kayttajanimi" id="kayttajanimi" type="text" class="form-control form-control-lg" placeholder="Käyttäjänimi">
                <input name="salasana" id="salasana" type="password" class="form-control form-control-lg" placeholder="Salasana">
                <button type="submit" class="btn btn-block btn-lg btn-primary">Kirjaudu!</button>
              </div>
       		</div>
       		<%
			if(request.getParameter("ok")!=null){
				if(request.getParameter("ok").equals("1")){
					out.print("Rekisteröinti Onnistui!");
				}
			}
       		if(request.getParameter("salasana")!=null){
				if(request.getParameter("salasana").equals("0")){
					out.print("Väärä salasana!");
				}
			}
			%>
          </form>
        </div>
      </div>
    </div>
  </header>
</body>
</html>