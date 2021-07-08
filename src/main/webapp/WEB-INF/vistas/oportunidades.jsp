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
			  	<h1 class="text-titles">Oportunidades </h1>
			</div>
		</div>
		
		<c:if test="${not empty mensaje}">
		        <h4><span>${mensaje}</span></h4>
	        </c:if>
	         <c:if test="${not empty combos}">
				<div class="row">
					<c:forEach items="${combos}" var="combo">
		  				<div class="col-sm-6 col-md-4">
		    				<div class="thumbnail">
		      					<img alt="100%x200" data-src="holder.js/100%x200" src="img/pngegg.png" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
		      					<div class="caption">
		        					<h3>${combo.nombre}</h3>
		        					<p>${combo.descripcion}</p>
		       						<p>stock disponible: ${combo.stock}</p>
		       						<c:if test="${combo.tieneDescuento == true}">
		       						<h4><span>Este Combo Tiene Descuento</span></h4>
	       							 </c:if>
	       							 <h5>Precio Final ${combo.precio} !!</h5>
		       						<p><a href=agregarACarrito?id=${combo.id} class="btn btn-default" id="boton-agregar-carrito" role="button">Agregar al Carrito</a></p>
		       			
		      					</div>
		    				</div>
		  				</div>
					</c:forEach>
				</div>
			</c:if>
		</section>


<!-- Modal de ayuda -->
<%@ include file="includes/DialogHelpModal.jsp"%>
<!--====== Scripts -->
	<script>
		$.material.init();
	</script>
</body>
</html>