<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="includes/cabecera.jsp"%>
 <style type="text/css">
.boton {
 border: 0;
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
			  	<h1 class="text-titles"><i class="zmdi zmdi-eye"></i>Detalle </h1>
			</div>
		</div>
		

	<div class="container-fluid ">
		<div class="col-sm-8">
		  <div class="panel panel-success">
             <div class="panel-heading">${combo.nombre}
              <p class="text-right"><img  width="36" height="36" class="img-circle" src="img/positivos.png" title="Me Gusta" alt="Me Gusta">${positivos}
                 <img  width="36" height="36" class="img-circle" src="img/negativos.png" title="No me Gusta" alt="No me gusta">${negativos}
              </p>
             </div>
               <div class="panel-body">
                <p class="text-success">Descripcion:</p>${combo.descripcion}
                </div>

              <ul class="list-group">
              <li class="list-group-item"><span class="text-success">Estacion:</span>${combo.estacion}</li>
             
              <li class="list-group-item"><span class="text-success">Stock:</span>${combo.stock}</li>
          
              <li class="list-group-item"><span class="text-success">Precio:</span>${combo.precio}</li>
            
              <li class="list-group-item"><span class="text-success">Peso Aprox:</span>${combo.peso}</li>
              
              <li class="list-group-item"><span class="text-success">Vencimiento:</span>${combo.vencimiento}</li>
              
            </ul>

         </div>
  
       </div> 
   </div>    
  <a href="verCombos"class="btn btn-primary">Volver </a>
  

  
 <!-- SECCION COMENTARIOS -->
 
 		<div class="container-fluid">
			  	<h1 class="text-titles"><i class="zmdi zmdi-comment-text"></i>Comentarios: </h1>
	 
	  <!-- LISTAR COMENTARIOS -->
		 	<c:if test="${not empty comentarios}">
		 	   <div class="container-fluid ">      
                   	<div class="col-sm-8">
                   	
                   	 	<c:if test="${NoLeidoComentario == 0}">
                      	   <button type="button" id="marcarLeido" class="btn btn-primary" disabled="disabled" value="${combo.id}">
                               Marcar comentarios como leidos
                          </button>
                       </c:if>
                       
                       	<c:if test="${NoLeidoComentario != 0}">
                      	   <button type="button" id="marcarLeido" class="btn btn-primary" value="${combo.id}">
                               Marcar comentarios como leidos
                          </button>
                       </c:if>
                       
                   	<p class="text-right"><i class="zmdi zmdi-alert-circle-o title "></i>Hay ${NoLeidoComentario} comentarios sin leer</p>
                   	</div>
		 	
		     	<div class="col-sm-8">
		 		      <table class="table table-bordered">
				         <thead >
					       <tr>
						   <th scope="col">Usuario</div></th>					
						   <th scope="col">Comentario</th>
					       </tr>
				          </thead>			         
		 		          <tbody>
					      <c:forEach items="${comentarios}" var="comentarios">
		                    <tr>
							<td class="col-sm-3"><img src="img/anonimo.jpg" title="anonimo"  width="45" height="45">
							 	<button type="button"  class="boton text-primary"  value="${comentarios.usuario.id}" data-toggle="modal" data-target="#exampleModal">
                                 ${comentarios.usuario.nombre}
                                </button>    							 						             							  
                                </td>      
						      <c:if test="${comentarios.leido == 'false'}">
							    <td class="success"><c:out value="${comentarios.comentario}" /></td>
                             </c:if>
                             
                             <c:if test="${comentarios.leido == 'true'}">
							    <td ><c:out value="${comentarios.comentario}" /></td>
                             </c:if>	
						     
					        </tr>
		                  </c:forEach>
		                </tbody>
		               </table>   
		              </div>  		              
		     </c:if>
		  
		 
		  <c:if test="${empty comentarios}">
			        <h4><span>No se ha registrado ningun comentario</span></h4>
			        <br>
		        </c:if>	
		  
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
	$('#myModal').on('shown.bs.modal', function () {
		  $('#myInput').trigger('focus')
		})
	</script>
 <script src="js/mostrarperfil.js"></script>
  <script src="js/marcarComentariosLeidos.js"></script>
</body>
</html>		