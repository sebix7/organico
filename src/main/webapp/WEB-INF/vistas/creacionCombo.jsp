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
			  <h1 class="text-titles">Creacion de combos </h1>
			</div>
		</div>				<form:form action="crear" method="POST" modelAttribute="combo">
			<div>
				<label for="nombre">Nombre:</label>
				<form:input path="nombre" type="text" id="nombre" class="form-control" />
			</div>
			<div>
				<label for="descripcion">Descripcion del combo:</label>
				<form:input path="descripcion" type="text" id="descripcion" class="form-control" />
			</div>
			<div>
				<label for="precio">Precio:</label>
				<form:input path="precio" type="number" id="precio" class="form-control" />
			</div>
			<div>
				<label for="peso">Peso en gramos:</label>
				<form:input path="peso" type="number" id="peso" class="form-control" />
			</div>
			<div>
				<label for="stock">Stock:</label>
				<form:input path="stock" type="number" id="stock" class="form-control" />
			</div>
			
			<div>
				<label for="estacion">Estacion:</label>
				<form:input path="estacion" type="text" id="estacion" class="form-control"/>
			</div>
			<button class="btn btn-primary" type="submit">Registrar Combo</button>
			<p class="text-center text-muted text-uppercase">${create}</p>
			
		</form:form>
					<a href="homeVendedor"class="btn btn-primary">Volver Home</a>
	</section>


<!-- Modal de ayuda -->
<%@ include file="includes/DialogHelpModal.jsp"%>
<!--====== Scripts -->
	<script>
		$.material.init();
	</script>
</body>
</html>