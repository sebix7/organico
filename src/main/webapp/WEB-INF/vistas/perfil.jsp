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
			  <h1 class="text-titles"><i class="zmdi zmdi-face zmdi-hc-fw"></i>Perfil </h1>
			</div>
			<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li class="active"><a href="#new" data-toggle="tab"></a></li>
					  	<li><a href="#list" data-toggle="tab">Mis Datos</a></li>
					</ul>
			</div>
		</div>
		
	
		<div class="container-fluid">

							<form:form class="form-horizontal" role="form" action="actualizar-perfil" method="post" modelAttribute="usuario">
							<form:input type="hidden" value="${id}" path="id" class="form-control" />
							<form:input type="hidden" value="${activo}" path="activo" class="form-control" />	
								<div class="form-group"></div>
							
								<div class="form-group">
									<div class="col-md-8 col-md-offset-2">
										<div class="input-group">
										<span class="input-group-addon">Nombre: </span> 
											<form:input type="text" value="${nombre}" path="nombre" class="form-control" required="required" placeholder="Ingrese su nombre y apellido." />				
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-md-8 col-md-offset-2">
										<div class="input-group">
											<span class="input-group-addon">Correo :</span> 
											<form:input type="email" value="${email}" path="email" class="form-control" required="required" placeholder="Ingrese su email. Por ejemplo: (usuario@correo.com)"/>				
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<div class="col-md-8 col-md-offset-2">
										<div class="input-group">
											<span class="input-group-addon">Contraseña :</span> 
											<form:input type="password" value="${password}" path="password" class="form-control" required="required" placeholder="Ingrese su contraseña."/>				
										</div>
									</div>
								</div>
								
							<div class="form-group">
							<div class="col-md-8 col-md-offset-2">
								<button type="submit"  class="btn btn-success">Guardar cambios</button>
							</div>
						</div>

						</form:form>
							
					</div>
		</div>
			<div class="row">
			                <div class="col-md-6 col-md-offset-3">
			                <c:if test="${not empty mensaje}">
			                <ol class="breadcrumb text-center ">
						<li class="breadcrumb-item text-success "><h2>${mensaje}</h2></li>
					</ol>
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