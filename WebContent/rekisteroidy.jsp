<%@include file="header.jsp" %>
 <!-- Navigation -->
  <nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      <a class="navbar-brand" onclick="document.location='index.jsp'">FrisbeeGolf</a>
    
      <div class="left">
      		<a class="btn btn-primary text-white" onclick="document.location='kirjaudu.jsp'">Kirjaudu</a>
      		<a class="btn btn-primary text-white" onclick="document.location='rekisteroidy.jsp'">Rekister�idy</a>
 		</div>
 
    </div>
  </nav>
	<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <h1 class="mb-5">Rekister�idy K�ytt�j�ksi!</h1>
        </div>
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
          <form action="Servlet_UusiPelaaja" method="post" id="rekisteroidy">
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
                <input name="etunimi" id="etunimi" type="text" class="form-control form-control-lg" placeholder="Etunimi">
                <input name="sukunimi" id="sukunimi" type="text" class="form-control form-control-lg" placeholder="Sukunimi">
                <input name="kayttajanimi" id="kayttajanimi" type="text" class="form-control form-control-lg" placeholder="K�ytt�j�nimi">
                <span id="kayttajainfo"></span>
                <input name="salasana" id="salasana" type="password" class="form-control form-control-lg" placeholder="Salasana">
                <button type="submit" class="btn btn-block btn-lg btn-primary">Rekister�idy!</button>
              </div>
       		</div>
       		<%
			if(request.getParameter("ok")!=null){
				if(request.getParameter("ok").equals("0")){
					out.print("Rekister�inti ep�onnistui!");
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
	
	$("#kayttajanimi").blur(function(){
	    $.ajax({url: "Servlet_Kayttaja_Ajax?kayttajanimi="+$("#kayttajanimi").val(), success: function(result){
	        $("#kayttajainfo").html(result);
	    }});
	});
	
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
				
				document.forms["rekisteroidy"].submit();
			}			
		}		
	});   
});
</script>
</body>
</html>