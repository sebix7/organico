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
			  <h1 class="text-titles"><i class="zmdi zmdi-toys"></i>Aplica Descuentos al combos </h1>
			</div>
			<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li class="active"><a href="#new" data-toggle="tab"></a></li>
					  	<li><a href="#list" data-toggle="tab">Descuentos</a></li>
					</ul>
			   </div>
		   </div>
	
<div class="container">			
			
			
		<form:form action="aplicarDescuento" method="POST">
<div class="form-group">
					<div class="col-md-9 col-md-offset-2">
						<div>
				<p class="text-star text-muted text-uppercase">Descuento Habilitados para Tu Combo: ${nombre}</p>
		<input type="radio" id="descuento" name="descuento" value="5" checked>
  		<label for="descuento">5% de Descuento</label><br>
  		<input type="radio" id="descuento" name="descuento" value="10">
  		<label for="descuento">10% de Descuento</label><br>
  		<input type="radio" id="descuento" name="descuento" value="20">
  		<label for="descuento">20% de Descuento</label><br>
  		<label for="descuentosAlCombo"></label>
		<input type="hidden" id="descuentosAlCombo" name="descuentosAlCombo" value="${combo.id}">
						</div>
				  <div class="form-group">
				  <div class="col-md-9 col-md-offset-2">
		     	      <button class="btn btn-primary" type="submit">Aplicar Descuento</button>
		     	      </div>
			      </div>
				         
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