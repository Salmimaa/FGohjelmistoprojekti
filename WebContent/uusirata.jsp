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
	
		<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">Lis‰‰ uusi rata!</h1>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
          <form action="Servlet_UusiRata" method="post" id="uusirata">
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
                <input name="ratanimi" id="ratanimi" type="text" class="form-control form-control-lg" placeholder="Radan nimi">
                <input name="osoite" id="osoite" type="text" class="form-control form-control-lg" placeholder="Osoite">
                <input name="postinumero" id="postinumero" type="text" class="form-control form-control-lg" placeholder="Postinumero">
                <span id="postitoimipaikka"></span>
                <input name="vaylamaara" id="vaylamaara" type="text" class="form-control form-control-lg" placeholder="V‰yl‰m‰‰r‰">
                <button type="submit" class="btn btn-block btn-lg btn-primary">Tallenna!</button>
              </div>
       		</div>
       		<%
			if(request.getParameter("ok")!=null){
				if(request.getParameter("ok").equals("0")){
					out.print("Tallentaminen ep‰onnistui");
				}
			}
       		if(request.getParameter("vaylaok")!=null){
				if(request.getParameter("vaylaok").equals("0")){
					out.print("V‰ylien Tallentaminen ep‰onnistui ota yhteys IT tukeen");
				}
			}

			%>
          </form>
        </div>
      </div>
    </div>
  </header>
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