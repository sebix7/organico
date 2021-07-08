<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="includes/cabecera.jsp"%>
</head>
<body>
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
			  	<h1 class="text-titles">Combos </h1>
			</div>
		</div>
		
		
	<form class="form-horizontal" action="filtro1" method="Get">
	
	  <p>
	  
	<div  class="form-group">
			<div class="col-md-9 col-md-offset-2">
				<p class="text-start text-muted text-uppercase">Estacion:</p>
		<input type="radio" id="Verano" name="estacion" value="Verano" checked>
  		<label for="Verano">Verano</label><br>
  		<input type="radio" id="Invierno" name="estacion" value="Invierno">
  		<label for="Invierno">Invierno</label><br>
  		<input type="radio" id="Primavera" name="estacion" value="Primavera" >
  		<label for="Primavera">Primavera</label><br>
  		<input type="radio" id="Otono" name="estacion" value="Otono">
  		<label for="Otono">Otoño</label><br>
  		 </div>
			</div>
	
	
	 <button class="btn btn-primary" type="submit">Buscar Combo por estacion</button>
		     	     
	</form>		
		<form class="form-horizontal" action="filtro2" method="Get">

	<div  class="form-group">
			<div class="col-md-9 col-md-offset-2">
				<p class="text-start text-muted text-uppercase">Estacion:</p>
		<input type="radio" id="menor" name="precio" value="menor" checked>
  		<label for="menor">Menor Precio</label><br>
  		<input type="radio" id="mayor" name="precio" value="mayor">
  		<label for="mayor">Mayor Precio</label><br>
  		 </div>
			</div>
	 <button class="btn btn-primary" type="submit">Ordenar Combo por Precio</button>
		     	     
	</form>	
	
		<form class="form-horizontal" action="filtro3" method="Get">

	<div  class="form-group">
			<div class="col-md-9 col-md-offset-2">
				<p class="text-start text-muted text-uppercase">Con Descuento:</p>
		<input type="radio" id="si" name="descuento" value="si" checked>
  		<label for="si">Con Descuentos</label><br>
  		<input type="radio" id="no" name="descuento" value="no">
  		<label for="no">Sin Descuentos</label><br>
  		 </div>
			</div>
	 <button class="btn btn-primary" type="submit">Ver Combos Con Descuetos</button>
		     	     
	</form>	
	</section>


<!-- Modal de ayuda -->
<%@ include file="includes/DialogHelpModal.jsp"%>
<!--====== Scripts -->
	<script>
		$.material.init();
	</script>
</body>
</html>