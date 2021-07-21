<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyAiq3xISXSZYgkd9GDAOdajy4NK2d3L7dY"></script>
<%@ include file="includes/cabecera.jsp"%>
</head>
<body  onload="loadMap()">
<!-- SideBar -->
<%@ include file="includes/SideBar.jsp"%>



<!-- Content page-->
	<section class="full-box dashboard-contentPage">
		<!-- NavBar -->
		<nav class="full-box dashboard-Navbar">
			<ul class="full-box list-unstyled text-right">
				<li class="pull-left">
					<a href="#!" class="btn-menu-dashboard"><i class="zmdi zmdi-more-vert"></i></a>
				</li>
				<li>
					<a href="#!" class="btn-search">
						<i class="zmdi zmdi-search"></i>
					</a>
				</li>
				<li>
					<a href="#!" class="btn-modal-help">
						<i class="zmdi zmdi-help-outline"></i>
					</a>
				</li>
			</ul>
		</nav>
		<!-- Content page -->
		<div class="container-fluid">
			<div class="page-header">
			  	<h1 class="text-titles">Localizacion </h1>
			</div>
		</div>
		
		<script>
    function loadMap() {

        var mapOptions = {
            center:new google.maps.LatLng(-34.6686986,-58.5614947),
            zoom:12,
            panControl: false,
            zoomControl: false,
            scaleControl: false,
            mapTypeControl:false,
            streetViewControl:true,
            overviewMapControl:true,
            rotateControl:true,
            mapTypeId:google.maps.MapTypeId.ROADMAP
        };

        var map = new google.maps.Map(document.getElementById("mapa"),mapOptions);

    

        google.maps.event.addListener(map, "click", function(event) {
            var lat = event.latLng.lat();
            var lng = event.latLng.lng();

            document.a1.lat.value = lat;
            document.a1.lon.value = lng;

        });

    }


</script>

   <div class="container-fluid" style="padding: 30px 10px;">
		  <h2><span>Localizate en el mapa</span></h2>
		  
		  <div class="container-fluid" id="mapa" style="width:1300px; height:400px;"></div>
		
		</div>


<div class="container-fluid">

<p>Has Click sobre el mapa</p>

						<form name="a1" method="get" action="procesarLocalizacion">
						<div class="container-fluid" style="padding: 30px 10px;">
  <label for="lat">Latitud:</label><br>
  <input id="lat" type="number" id="latitud" name="latitud"><br>
  <label for="lng">Longitud:</label><br>
  <input id="lon" type="number" id="longitud" name="longitud"><br>

   <button class="btn btn-primary" type="submit">Registrar</button>
   </div>

						</form>
							
					</div>

		
	</section>


<!-- Modal de ayuda -->
<%@ include file="includes/DialogHelpModal.jsp"%>
<!--====== Scripts -->
	<script>
		$.material.init();
	</script>
</body>
</html>