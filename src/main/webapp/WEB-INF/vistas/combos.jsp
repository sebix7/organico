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
					<a href="carrito" class="menu-dashboard">
						<i class="zmdi zmdi-shopping-cart"></i>
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
		<div class="full-box text-center" style="padding: 30px 10px;">
			<c:if test="${not empty mensaje}">
		        <h4><span>${mensaje}</span></h4>
	        </c:if>
	        <c:if test="${not empty combos}">
				<div class="row">
					<c:forEach items="${combos}" var="combo">
						<c:if test="${combo.stock > 0}">
			  				<div class="col-sm-6 col-md-4">
			    				<div class="thumbnail">
			      					<img alt="100%x200" data-src="holder.js/100%x200" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTkxIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDE5MSAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTc5YTU3OTljNzcgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMHB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNzlhNTc5OWM3NyI+PHJlY3Qgd2lkdGg9IjE5MSIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI2OS41MzkwNjI1IiB5PSIxMDQuNDAxNTYyNSI+MTkxeDIwMDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
			      					<div class="caption">
			        					<h3>${combo.nombre}</h3>
			       						<p>Stock disponible: ${combo.stock}</p>
			       						<c:if test="${combo.tieneDescuento == true}">
				       						<h4><span>Este Combo Tiene Descuento</span></h4>
										</c:if>
			        					<p><a href=verDetalle?id=${combo.id} class="btn btn-primary" role="button">Ver Detalles</a></p>
			        					<c:choose>
			    							<c:when test="${combo.stock > 0}">
			        							<p><a href=agregarACarrito?id=${combo.id} class="btn btn-default" id="boton-agregar-carrito" role="button">Agregar al Carrito</a></p>
									        </c:when>
									        <c:otherwise>
									        	<p><span class="btn btn-danger" style="text-transform: uppercase;">Sin stock</span></p>
			   								</c:otherwise>
										</c:choose>
			      					</div>
			    				</div>
			  				</div>
		  				</c:if>
					</c:forEach>
				</div>
			</c:if>
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