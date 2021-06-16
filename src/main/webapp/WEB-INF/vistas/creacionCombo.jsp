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
			  <h1 class="text-titles"><i class="zmdi zmdi-toys"></i>Creacion de combos </h1>
			</div>
			<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li class="active"><a href="#new" data-toggle="tab"></a></li>
					  	<li><a href="#list" data-toggle="tab">Formulario</a></li>
					</ul>
			   </div>
		   </div>
	
<div class="container">			
			
			
		<form:form action="crear" method="POST" modelAttribute="combo">
			<div class="form-group">
					<div class="col-md-9 col-md-offset-2">
				
				          <span for="nombre">Nombre:</span>
				          <form:input path="nombre" type="text" id="nombre" class="form-control" />
			          </div>
			         </div>
			        
			<div class="form-group">
				<div class="col-md-9 col-md-offset-2">
				<span for="descripcion">Descripcion del combo:</span>
				<form:input path="descripcion" type="text" id="descripcion" class="form-control" />
			</div>
		 </div>
		 	
			<div class="form-group">
				<div class="col-md-9 col-md-offset-2">
				   <span for="precio">Precio:</span>
				   <form:input path="precio" type="number" id="precio" class="form-control" />
			    </div>
			</div>
			
			<div class="form-group">
				<div class="col-md-9 col-md-offset-2">
				<span for="peso">Peso en gramos:</span>
				<form:input path="peso" type="number" id="peso" class="form-control" />
			    </div>
			   </div>
			   
			<div class="form-group">
				<div class="col-md-9 col-md-offset-2">
				   <span for="stock">Stock:</span>
				   <form:input path="stock" type="number" id="stock" class="form-control" />
			   </div>
			</div>
			
			<div class="form-group">
				<div class="col-md-9 col-md-offset-2">
				  <span for="estacion">Estacion:</span>
				  <form:input path="estacion" type="text" id="estacion" class="form-control"/>
			    </div>
			    </div>
			    
			    <div class="form-group">
				  <div class="col-md-9 col-md-offset-2">
		     	      <button class="btn btn-primary" type="submit">Registrar Combo</button>
		     	      </div>
			      </div>
		     	      	<div class="row">
			                <div class="col-md-6 col-md-offset-3">
			                <c:if test="${not empty create}">
			                <ol class="breadcrumb text-center ">
						<li class="breadcrumb-item text-success "><h2>${create}</h2></li>
					</ol>
			</c:if> 
			  
		        </form:form>
			    <a href="homeVendedor"class="btn btn-primary">Volver Home</a>
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