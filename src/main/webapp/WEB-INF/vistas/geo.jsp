<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyAiq3xISXSZYgkd9GDAOdajy4NK2d3L7dY"></script>
<%@ include file="includes/cabecera.jsp"%>
</head>
<body  onload="initializee();">
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
		function initializee() {
		    // Creating map object
		    var map = new google.maps.Map(document.getElementById('mapa_canvas'), {
		        zoom: 12,
		        center: new google.maps.LatLng(-34.686078060293006, -58.61402310230241),
		        mapTypeId: google.maps.MapTypeId.ROADMAP
		    });

		    // creates a draggable marker to the given coords
		    var vMarker = new google.maps.Marker({
		        position: new google.maps.LatLng(-34.686078060293006, -58.61402310230241),
		        draggable: true
		    });

		    // adds a listener to the marker
		    // gets the coords when drag event ends
		    // then updates the input with the new coords
		    google.maps.event.addListener(vMarker, 'dragend', function (evt) {
		        $("#txtaLat").val(evt.latLng.lat().toFixed(6));
		        $("#txtaLng").val(evt.latLng.lng().toFixed(6));

		        map.panTo(evt.latLng);
		    });

		    // centers the map on markers coords
		    map.setCenter(vMarker.position);

		    // adds the marker on the map
		    vMarker.setMap(map);
		}



</script>
<c:if test="${not empty mensaje}">
		        <h4><span>${mensaje}</span></h4>
	        </c:if>
   <div class="container-fluid" style="padding: 30px 10px;">
		  <h2><span>Localizate en el mapa</span></h2>
		  <div id="mapa_canvas" style="width: auto; height: 500px;">
    </div>
		
		</div>
		
		


<div class="container-fluid">

<div  class="full-box text-center" style="padding: 30px 10px;">
			
			<form method="get" action="procesarLocalizacion" >
 
    <input name="lata" id="txtaLat" type="hidden" style="color:red" value="-34.686078060293006" />
  
    <input  name="lona" id="txtaLng" type="hidden" style="color:red" value="-58.61402310230241" /><br />
   
      <button class="btn btn-primary" type="submit">Grabar</button>
			</form>
	       		
							
					</div>
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