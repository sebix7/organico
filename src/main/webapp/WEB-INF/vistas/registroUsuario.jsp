<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="includes/cabecera.jsp"%>
</head>
<body class="cover" style="background-image: url(img/fondo.jpg);">
	<header class="container">
	</header>
	<main class="container">
		<form:form class="full-box logInForm" action="procesarRegistro" method="POST" modelAttribute="usuario">
			<p class="text-center text-muted text-uppercase">Crea tu cuenta</p>
			<div>
				<label for="correo">Email:</label>
				<form:input path="email" type="email" id="email" class="form-control" />
			</div>
			<div>
				<label for="password">Contraseña:</label>
				<form:input path="password" type="password" id="password" class="form-control"/>
			</div>
			<div>
				<label for="repassword">Repetir contraseña:</label>
				<input type="password" name="repassword" id="repassword" class="form-control">
			</div>
			<div>
				<p class="text-center text-muted text-uppercase">Quieres ser Vendedor O Comprador:</p>
		<input type="radio" id="comprador" name="rol" value="Cliente">
  		<label for="comprador">Comprador</label><br>
  		<input type="radio" id="vendedor" name="rol" value="Vendedor">
  		<label for="vendedor">Vendedor</label><br>
			</div>
			<button class="btn btn-primary" type="submit">Registrar</button>
			<a href="login"class="btn btn-primary">Volver Login</a>
		</form:form>
	</main>
</body>
</html>