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
         
         	<c:if test="${resultado == true}">
              <span> Valorar Combo: </span>
	          <img style="cursor: pointer" id="likeIcon"  value="true" width="36" height="36" class="img-circle" src="img/MeGusta.png" title="Me Gusta" alt="Me Gusta" > | 
			  <img style="cursor: pointer" id="dislikeIcon"  value="false" width="36" height="36" class="img-circle" src="img/NoMeGusta.png" title="No me Gusta" alt="No Me Gusta" >
										  
			  <input type="hidden" id="Idcombo" value="${combo.id}" />
		   
		    </c:if>	
       </div> 
   </div>    
  <a href="combos"class="btn btn-primary">Volver </a>
  
 <!-- SECCION COMENTARIOS -->
 
 		<div class="container-fluid">
			  	<h1 class="text-titles"><i class="zmdi zmdi-comment-text"></i>Comentarios: </h1>
			<!-- Solo es visible si el cliente no realizo ningun comentario -->
			
			<c:if test="${estadoComentario == false}">
			
                  <legend>Realizar comentario:</legend>
		          <div class="form-group">
               
                   <input type="hidden" id="Idcombo" value="${combo.id}"  />
                   <textarea id="comentario" name="comentario" cols="40" rows="3" ></textarea>
               
                  <button class="btn btn-success" id="boton" type="submit">Envíe su mensaje</button>
                  </div>
         
              </c:if>	  
		 </div>
	 
	  <!-- LISTAR COMENTARIOS -->
		 	<c:if test="${not empty comentarios}">
		 		<div class="col-sm-8">
					<c:forEach items="${comentarios}" var="comentarios">
		            <ul class="list-group comentario" > 
		            <li class="list-group-item list-group-item-action list-group-item-success">${comentarios.comentario}</li>
		            </ul>
		            
		            </c:forEach>
		     </c:if>
		  
		  
		  
</section>

<!-- Modal de ayuda -->
<%@ include file="includes/DialogHelpModal.jsp"%>
<!--====== Scripts -->
	<script>
		$.material.init();
	</script>
	 <script src="js/valorarCombos.js"></script>
	 <script src="js/realizarComentario.js"></script>


</body>
</html>		
		