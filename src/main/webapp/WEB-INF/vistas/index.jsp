<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Principal</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- Simple line icons-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
</head>
<body>
  <!-- Navigation-->
      
        <nav class="navbar menu static-top">
            <div class="container">
                <a class="navbar-brand" href="index">Vida Sana</a>
                <ul class="list-inline mb-2">
                    <li class="list-inline-item"><a href="#!">¿Como pedir?</a></li>
                    <li class="list-inline-item">⋅</li>
                    <li class="list-inline-item"><a href="#!">Contacto</a></li>
                    <li class="list-inline-item">⋅</li>
                    <li class="list-inline-item"><a href="#!">Productos</a></li>
                    <li class="list-inline-item">⋅</li>
                    <li class="list-inline-item"><a href="registroUsuario">Registrarse</a></li>
                </ul>
                <a class="btn btn-primary" href="login">Login</a>
            </div>
        </nav>
    
        <header class="masthead text-white text-center">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 mx-auto"><h1 class="mb-5">Saludable * Fresco * Organico</h1></div>
                </div>
            </div>
        </header>
        <!-- Icons Grid-->
        <section class="features-icons bg-light text-center">
            <div class="container">
                <div class="row">
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#!"><img class="card-img-top" src="assets/img/EnvioDomicilio.jpg"..." /></a>
                                <div class="card-body">
                                    <h4 class="card-title"><a href="#!">Enviamos tu compra</a></h4>
                                    <p class="card-text">Marcá la fecha y horario que prefieras entre las opciones disponibles según tu zona y
                                         recibí tu pedido en tu casa, trabajo o el lugar que vos elijas.
                                        Recorda que los envios tienen cargo</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#!"><img class="card-img-top" src="assets/img/retiroSucursal.png" alt="..." /></a>
                                <div class="card-body">
                                    <h4 class="card-title"><a href="#!">Retira por puntos de entrega</a></h4>
                                    <p class="card-text">Completá el formulario para pedirnos y retirar por las sucursales que elijas. 
                                        Solo podés pagar en efectivo en la sucursal que selecciones.  </p>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#!"><img class="card-img-top" src="assets/img/mediosPago.jpg" alt="..." /></a>
                                <div class="card-body">
                                    <h4 class="card-title"><a href="#!">Paga como quieras</a></h4>
                                    <p class="card-text">Elegí la forma de pago que prefieras usar: efectivo, transferencia o tarjeta de crédito… y listo.</p>
                                </div>
                            </div>
                        
            </div>
                </div>
                    </div>
                    
                                 <div class="full-box text-center" style="padding: 30px 10px;">
			
		        <h4><span>Combos Seleccionados</span></h4>
	       
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
		       						<form action="" method="POST">
		       						<label for="EnvioDeIdCompra"></label>
									<input type="hidden" id="EnvioDeIdCompra" name="EnvioDeIdCompra" value="${combo.id}">
		       						<button type="submit"  class="btn btn-success">Comprar Combo</button>
		       						</form>
		      					</div>
		    				</div>
		  				</div>
					</c:forEach>
				</div>
			</c:if>
		</div>
                   
                    
        </section>
        
                     
        
                     
                     
       
        <!-- Image Showcases-->
        <section class="showcase">
            <div class="container-fluid p-0">
                <div class="row no-gutters">
                    <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('assets/img/orgánicos.jpg')"></div>
                    <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                        <h2>Bolsones 100% libres de agrotoxicos</h2>
                        <p class="lead mb-0">Una selección de frutas y verduras organicas y de estación,
                             cosechadas especialmente para vos.
                              Recibí cada semana lo mejor de nuestra huerta a un precio promocional. 
                              Para que tus comidas sean más variadas, para ampliar tu menú o 
                              para sorprender a los que más quieras con nuevos platos</p>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-lg-6 text-white showcase-img" style="background-image: url('assets/img/productos.jpeg')"></div>
                    <div class="col-lg-6 my-auto showcase-text">
                        <h2>Productos Organicos</h2>
                        <p class="lead mb-0">No contienen químicos, pesticidas, fertilizantes o aditivos sintéticos.
                            ¡Están llenos de vida! Es por eso que conservan intactos su sabor, su aroma y su color.                            
                            Tienen muchas más vitaminas, minerales y antioxidantes que los productos convencionales.                        
                            Protegen la salud del consumidor y del agricultor.
                            Su forma de producción apoya la biodiversidad y ayuda a prevenir el calentamiento global.</p>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('assets/img/granja.jpg')"></div>
                    <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                        <h2>Trabajamos con chicos agricultores</h2>
                        <p class="lead mb-0">La producción orgánica promueve el desarrollo económico de pequeños productores,
                             la protección del medio ambiente y sus recursos y el cuidado de la salud humana.</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- Testimonials-->
        <section class="testimonials text-center bg-light">
            <div class="container">
                <h2 class="mb-5">Por Que consumir "Organico"?</h2>
              
                <div class="row">
                    <div class="col-lg-4 ml-auto"><p class="lead">Nos interesa cuidar tu salud y el medio ambiente.Al elegir nuestra tienda 
                        online estas apoyando la biodiversidad y a los pequeños productores:Una responsabilidad compartida desde el 
                        productor al consumidor
                    </p></div>
                    <div class="col-lg-4 mr-auto"><p class="lead">Los productos no contienen químicos, pesticidas, fertilizantes o aditivos sintéticos
                        Tienen muchas más vitaminas, minerales y antioxidantes que los productos convencionales.
                        Protegen la salud del consumidor y del agricultor.
                        Su forma de producción apoya la biodiversidad y ayuda a prevenir el calentamiento global.
                    </p></div>
                </div>
            </div>
        </section>
        <!-- Call to Action-->
        <section class="call-to-action text-white text-center">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="footer menu">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
                        <ul class="list-inline mb-2">
                            <li class="list-inline-item"><a href="#!">¿Como pedir? </a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a href="#!">Contacto </a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a href="#!">Productos </a></li>
                            <li class="list-inline-item">⋅</li>
                        </ul>
                        <p class="text-muted small mb-4 mb-lg-0">Taller Web 2021. All Rights Reserved.</p>
                    </div>
                    <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item mr-3">
                                <a href="#!"><i class="fab fa-facebook fa-2x fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item mr-3">
                                <a href="#!"><i class="fab fa-twitter-square fa-2x fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item">
                                <a href="#!"><i class="fab fa-instagram fa-2x fa-fw"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
</body>
</html>