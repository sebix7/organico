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
			  <h1 class="text-titles"><i class="zmdi zmdi-accounts-alt zmdi-hc-fw"></i> Usuarios del sistema </h1>
			</div>
		</div>


	<div class="container-fluid">
	<div class="col-md-12 main">		
		<div class="row">
		<div class="col-sm-4">
			<form action="usuarios" method="POST">
			    
		        <select  name = "roles">
		        <option value="" disabled selected>Tipo de Usuario</option>
                <option value = "Todos">Todos</option>
                <option value = "Cliente">Clientes</option>
                <option value = "Vendedor">Vendedor</option>
                <option value = "Administrador">Administrador</option>
                 </select>  
			    
				<br>
				<div class="col-sm-6">
					<button class="btn btn-lg btn-primary btn-block" type="submit">Buscar</button>
					<br>
					<br>
				</div>
			</form>
		   </div>
		
		   <table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Email</th>
						<th scope="col">Rol</th>
					</tr>
				</thead>
				<tbody>
					 <c:forEach var="lista" items="${busqueda}">

						<tr>
							<td><c:out value="${lista.id}" /></td>
							<td><c:out value="${lista.nombre}" /></td>
							<td><c:out value="${lista.email}" /></td>
							<td><c:out value="${lista.rol} " /></td>
							<td class="col-sm-2">
						    <button type="button" class="boton" class="btn btn-primary" value="${lista.id}" data-toggle="modal" data-target="#exampleModal">
                                 ver Perfil
                                </button>
		                   </td>
					    </tr>
					 </c:forEach>
				</tbody>
			</table>
		
		
		
</div>
</div>
</div>
</section>
 <!--  modal para visualizar Perfil-->

<%@ include file="includes/modalPerfil.jsp"%>


<!-- Modal de ayuda -->
<%@ include file="includes/DialogHelpModal.jsp"%>
<!--====== Scripts -->
	<script>
		$.material.init();
	</script>
	<script>
	$('#Modal').on('shown.bs.modal', function () {
		  $('#myInput').trigger('focus')
		})
	</script>
 <script src="js/mostrarperfil.js"></script>
</body>
</html>
