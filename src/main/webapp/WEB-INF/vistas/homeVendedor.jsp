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
			  <h1 class="text-titles">Secciones </h1>
			</div>
		</div>
	
		<div class="full-box text-center" style="padding: 30px 10px;">
			<article class="full-box tile">
				<div class="full-box tile-title text-center text-titles text-uppercase">
					Crear Combos
				</div>
				<div class="full-box tile-icon text-center">
				<i class="zmdi zmdi-toys"></i>
				</div>
				<div class="full-box tile-number text-titles">
					<p class="full-box"><i class="zmdi zmdi-long-arrow-down"></i></p>
					<small><a href="creacionCombo">Crear</a></small>
				</div>
			</article>
			
			<article class="full-box tile">
				<div class="full-box tile-title text-center text-titles text-uppercase">
					Clientes
				</div>
				<div class="full-box tile-icon text-center">
					<i class="zmdi zmdi-male-alt"></i>
				</div>
				<div class="full-box tile-number text-titles">
					<p class="full-box">10</p>
					<small>Register</small>
				</div>
			</article>
			<article class="full-box tile">
				<div class="full-box tile-title text-center text-titles text-uppercase">
					Filtrar Combos
				</div>
				<div class="full-box tile-icon text-center">
					<i class="zmdi zmdi-rotate-left"></i>
				</div>
				<div class="full-box tile-number text-titles">
					<p class="full-box">10</p>
					<small><a href="filtrar">Filtrar</a></small>
				</div>
			</article>
			<article class="full-box tile">
				<div class="full-box tile-title text-center text-titles text-uppercase">
					Estadisticas
				</div>
				<div class="full-box tile-icon text-center">
					<i class="zmdi zmdi-settings"></i>
				</div>
				<div class="full-box tile-number text-titles">
					<p class="full-box">70</p>
					<small>Register</small>
				</div>
			</article>
			<article class="full-box tile">
			   	   
				<div class="full-box tile-title text-center text-titles text-uppercase">
					Mi Perfil
				</div>
				<div class="full-box tile-icon text-center">
					<i class="zmdi zmdi-face "></i>
				</div>
					<div class="full-box tile-number text-titles">
					<p class="full-box"><i class="zmdi zmdi-check"></i></p>
					<small><a href="perfil">Ver/Editar</a></small>
				</div>
			</article>
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