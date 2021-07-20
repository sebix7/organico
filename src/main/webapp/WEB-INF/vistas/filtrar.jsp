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
			  	<h1 class="text-titles">Buscar Combo </h1>
			</div>
		</div>
		<form  action="filtro" method="Get">		
				<div class="col-md-9 col-md-offset-2">
		<p class="text-start text-muted text-uppercase">Estacion:</p>
		<select name="Estacion" class="form-select" aria-label="multiple select example">
			  
			  <option value="Verano" selected>Verano</option>
			  <option value="Primavera">Primavera</option>
			  <option value="Invierno">Invierno</option>
			  <option value="Otono">Otoño</option>
		</select>
		<br>
		<p class="text-start text-muted text-uppercase">Descuento:</p>
	
			  <select name="Descuento" class="form-select" aria-label="multiple select example">
			  <option value="no" selected>Sin Descuento</option>
			  <option value="si">Con Descuento</option>
		</select>
		<br>
		<p class="text-start text-muted text-uppercase">Ordenado Por Precio:</p>
		
			  	  <select name="precio" class="form-select" aria-label="multiple select example">
			  <option value="mayor" selected>Mayor Precio</option>
			  <option value="menor">Menor Precio</option>
		</select>
		<br>
		     	</div>
		<button class="btn btn-primary" type="submit">Buscar Combos</button>
			     
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