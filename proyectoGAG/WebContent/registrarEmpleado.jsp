<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro Empleado</title>
</head>
<body>
<a href = "index.jsp">volver a inicio</a><br/>

Introduce los datos de Empleado:<br/>
<form action="ServletRegistroEmpleadoAdmin" method="post" enctype="multipart/form-data" >

<div>
	<label for="nombre">Nombre</label></br>
	<input type="text" size="30" id="nombre" name="campoNombre" placeholder="Nombre">
</div>
<div>
	<label for="apellidos">Apellidos</label></br>
	<input type="text" size="30" id="apellidos" name="campoApellidos" placeholder="Apellidos"/>
</div>

<div>
	<label for="usuario">Usuario</label></br>
	<input type="text" size="30" id="usuario "name="campoUsuario" placeholder="Usuario">	
</div>
<div>
	<label for="password">Password</label></br>
	<input type="password" size="30" id="password "name="campoPassword" placeholder="Contraseña">	
</div>

<div>
	<label for="comentario">Comentario</label></br>
	<textarea  rows= "4" columns= "40" id="comentario" name="campoComentario"placeholder="Comentario"></textarea>
</div>

<div>
	<label for="fotografia">Fotografia:</label></br>
 	<input type="file" id="imagen" name= "campoImagen">
</div>
	
<input type="submit" value= "Aceptar"/>

</form>

</body>
</html>