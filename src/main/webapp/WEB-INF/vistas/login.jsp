<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
<%@ include file="includes/cabecera.jsp"%>
</head>


<body class="cover" style="background-image: url(img/fondo.jpg);">
		<form:form action="validar-login" method="POST" modelAttribute="usuario" class="full-box logInForm">
		<p class="text-center text-muted"><i class="zmdi zmdi-account-circle zmdi-hc-5x"></i></p>
		<p class="text-center text-muted text-uppercase">Inicia sesión con tu cuenta</p>
		<div class="form-group label-floating">
		  <label class="control-label" for="UserEmail">E-mail</label>
		<form:input path="email" id="email" type="email" class="form-control" />
		  <p class="help-block">Escribe tú E-mail</p>
		</div>
		
		<div class="form-group label-floating">
		  <label class="control-label" for="UserPass">Contraseña</label>
		  <form:input path="password" type="password" id="password" class="form-control"/> 
		  <p class="help-block">Escribe tú contraseña</p>
		</div>
		
		<div class="form-group text-center">
			<input type="submit" value="Iniciar sesión" class="btn btn-raised btn-danger">
		</div>
		
	
		<div class="form-group text-center">
			<a href="registroUsuario">No tienes cuenta,Registrate!</a>
		</div>
		
			<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
		
	</form:form>
	
	
	<!--====== Scripts -->
	<script>
		$.material.init();
	</script>
</body>
</html>