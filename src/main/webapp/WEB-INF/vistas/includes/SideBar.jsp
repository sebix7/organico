<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- SideBar -->

	<section class="full-box cover dashboard-sideBar" style="background-image: url(img/bolson1.jpg);">
		<div class="full-box dashboard-sideBar-bg btn-menu-dashboard"></div>
		<div class="full-box dashboard-sideBar-ct">
			<!--SideBar Title -->
			
			<div class="full-box text-uppercase text-center text-titles dashboard-sideBar-title">
				Vida Sana <i class="zmdi zmdi-close btn-menu-dashboard visible-xs"></i>
			</div>
			
			<!-- SideBar User info -->
			<div class="full-box dashboard-sideBar-UserInfo">
			<c:choose>
            <c:when test="${AdministradorId != null}">
				    <figure class="full-box">
					<img src="img/admin.png" alt="UserIcon">
					<figcaption class="text-center text-titles">Administrador</figcaption>
				    </figure>
				</c:when>
				<c:when test="${VendedorId != null}">
				    <figure class="full-box">
					<img src="img/cliente-icon.png" alt="UserIcon">
					<figcaption class="text-center text-titles">Vendedor</figcaption>
				    </figure>
				</c:when>
	            <c:otherwise>
			        <figure class="full-box">
					<img src="img/cliente-icon.png" alt="UserIcon">
					<figcaption class="text-center text-titles">Cliente</figcaption>
				    </figure>
			
			     </c:otherwise>
                 </c:choose>
				<ul class="full-box list-unstyled text-center">
					<li>
						<a href="#!" class="btn-exit-system">
							<i class="zmdi zmdi-power"></i>
						</a>
					</li>
				</ul>
			</div>
			
			<!-- SideBar Menu -->
			<c:choose>
            <c:when test="${AdministradorId != null}">
			<ul class="list-unstyled full-box dashboard-sideBar-Menu" >
				<li>
					<a href="homeAdministrador">
						<i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Principal
					</a>
				</li>
				<li>
					<a href="#!" class="btn-sideBar-SubMenu">
						<i class="zmdi zmdi-case zmdi-hc-fw"></i> Proveedores <i class="zmdi zmdi-caret-down pull-right"></i>
					</a>
					<ul class="list-unstyled full-box" style="padding-top: 0px;">
						<li>
							<a href="periodo"><i class="zmdi zmdi-timer zmdi-hc-fw"></i> Periodo</a>
						</li>
						<li>
							<a href="estadisticas"><i class="zmdi zmdi-book zmdi-hc-fw"></i> Estadisticas</a>
						</li>
					</ul>
					<a href="#!" class="btn-sideBar-SubMenu">
						<i class="zmdi zmdi-case zmdi-hc-fw"></i> Clientes <i class="zmdi zmdi-caret-down pull-right"></i>
					</a>
					<ul class="list-unstyled full-box" style="padding-top: 0px;">
						<li>
							<a href="periodo"><i class="zmdi zmdi-timer zmdi-hc-fw"></i> Periodo</a>
						</li>
						<li>
							<a href="estadisticas"><i class="zmdi zmdi-book zmdi-hc-fw"></i> Estadisticas</a>
						</li>
					</ul>
				</li>			
			</ul>
			
			</c:when>
			
			<c:when test="${VendedorId != null}">
			<ul class="list-unstyled full-box dashboard-sideBar-Menu" >
				<li>
					<a href="homeVendedor">
						<i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Principal
					</a>
				</li>
				<li>
					<a href="verCombos">
						<i class="zmdi zmdi-case zmdi-hc-fw"></i> Combos
					</a>
				</li>
				<li>
					<a href="#!">
						<i class="zmdi zmdi-case zmdi-hc-fw"></i> Clientes
					</a>
				</li>		
				<!--<li>
					<a href="#!" class="btn-sideBar-SubMenu">
						<i class="zmdi zmdi-case zmdi-hc-fw"></i> Proveedores <i class="zmdi zmdi-caret-down pull-right"></i>
					</a>
					<ul class="list-unstyled full-box">
						<li>
							<a href="periodo"><i class="zmdi zmdi-timer zmdi-hc-fw"></i> Periodo</a>
						</li>
						<li>
							<a href="estadisticas"><i class="zmdi zmdi-book zmdi-hc-fw"></i> Estadisticas</a>
						</li>
					</ul>
				</li>-->		
			</ul>
			</c:when>
			
	        <c:otherwise>
	        
	        <ul class="list-unstyled full-box dashboard-sideBar-Menu" >
				<li>
					<a href="homeCliente">
						<i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Home
					</a>
				</li>
				<li>
					<a href="combos">
						<i class="zmdi zmdi-cutlery zmdi-hc-fw"></i> Combos
					</a>
				</li>
				<li>
					<a href="carrito">
						<i class="zmdi zmdi-shopping-cart zmdi-hc-fw"></i> Carrito
					</a>
				</li>
			</ul>
	        
	        </c:otherwise>
            </c:choose>
		</div>
	</section>