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
				<li class="pull-left"><a href="#!" class="btn-menu-dashboard"><i
						class="zmdi zmdi-more-vert"></i></a></li>
				<li><a href="#!" class="btn-search"> <i
						class="zmdi zmdi-search"></i>
				</a></li>
				<li><a href="carrito" class="menu-dashboard"> <i
						class="zmdi zmdi-shopping-cart"></i>
				</a></li>
				<li><a href="#!" class="btn-modal-help"> <i
						class="zmdi zmdi-help-outline"></i>
				</a></li>
			</ul>
		</nav>
		<!-- Content page -->
		<div class="container-fluid">
			<div class="page-header">
				<h1 class="text-titles">Pedidos</h1>
			</div>
		</div>
		<div class="container-fluid">
			<div class="full-box text-center" style="padding: 30px 10px;">
				<c:if test="${not empty mensaje}">
					<h4>
						<span>${mensaje}</span>
					</h4>
				</c:if>
				<c:if test="${not empty pedidos}">
					<div class="row text-left">
						<table class="table">
							<thead>
								<tr>
									<th>Codigo del Pedido</th>
									<th>Estado</th>
									<th>Fecha de Emisión</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pedidos}" var="pedido">
									<tr>
										<td>${pedido.id}</td>
										<td><span class="label label-xl font-weight-boldest label-rounded label-success">${pedido.estado}</span></td>
										<td>${pedido.fechaDeEmision}</td>
										<th><a href="#!">VER DETALLE DEL PEDIDO</a></th>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
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