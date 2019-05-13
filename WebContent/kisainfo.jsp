<%@include file="header.jsp" %>

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
  <header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5"></h1>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
         <fieldset id="hakukisa">
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
              </div>
              
                <input type="button" name="haeKisa" id="haeKisa" class="btn btn-block btn-lg btn-primary" value="Etsi"></input>
            
            </div>
         </fieldset>
        </div>
      </div>
    </div>
  </header>

</body>
</html>