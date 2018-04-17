<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

</head>
<body>
<div class="container">
	<div class="form-group">
		<h1>Introduce tus datos para identificarte:</h1>
	</div>
	<div style="color: red">&nbsp;${mensaje}</div>

	<form action="ServletIdentificacion" method="post">
		<div class="form-group">
			<label for="campoUsuario">Usuario</label><br>
			<input type="text" size= "30" id="campoUsuario" name="campoUsuario" placeholder="Usuario">
		</div>
		<div class="form-group">
			<label for="campoPass">Contraseña:</label><br>
			<input type="password" size="30" id="campoPass" name="campoPass" placeholder="Contraseña">
		</div class="form-group">
		<input type="submit" value="ENTRAR"/>
		<div>
		<a href = "ServletPreparaRegistroEmpleado">Registrarse</a>&nbsp;
		</div>
</form>

</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>