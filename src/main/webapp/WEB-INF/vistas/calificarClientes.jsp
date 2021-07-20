<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="includes/cabecera.jsp"%>
<style >
.boton {
  background: none!important;
  border: none;
  padding: 0!important;
  /*optional*/
  font-family: arial, sans-serif;
  /*input has OS specific font-family*/

  text-decoration: underline;
  cursor: pointer;
}
</style>
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
				<h1 class="text-titles">Pedidos Cancelados</h1>
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
									<th scope="col" >Codigo del Pedido</th>
									<th scope="col">Estado</th>
									<th scope="col">Fecha de Emisión</th>							
									<th scope="col">Entrega</th>
									<th scope="col">Nombre Cliente</th>
									<th scope="col">Estado</th>
									<th scope="col">Accion</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${pedidos}" var="pedido">
									<tr>
										<td>${pedido.id}</td>
										<td class="text-success">${pedido.estado}</td>
										<td>${pedido.fechaDeEmision}</td>																			
											
									    <td>${pedido.entrega}</td>
										
										<td>
										<button   class="boton text-primary"  value="${pedido.carro.usuario.id}" data-toggle="modal" data-target="#exampleModal">
                                            ${pedido.carro.usuario.nombre}
                                            </button> 
                                        </td>	
                                               <c:if test="${pedido.carro.usuario.activo == true}">
                                                  <td>Activo</td>
                                          	    </c:if>
                                          	    <c:if test="${pedido.carro.usuario.activo == false}">
                                                  <td>Inactivo</td>
                                          	   </c:if>
                                          	
                                          	
										       <c:if test="${pedido.carro.usuario.activo == true}">
                                    	       <td><button  class="NOactiva text-danger"  value="${pedido.carro.usuario.id}"  >
                                                Desactivar Usuario
                                                </button> </td>	
                                               	</c:if>
                                                <c:if test="${pedido.carro.usuario.activo == false}">
                                               	  <td><button  class="activa text-danger"  value="${pedido.carro.usuario.id}" >
                                                    Activar Usuario
                                                </button> </td>	
                                        		</c:if>		
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
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
	 <script src="js/mostrarperfil.js"></script>
	 <script src="js/desactivarUsuario.js"></script>
	  <script src="js/activarUsuario.js"></script>
</body>
</html>