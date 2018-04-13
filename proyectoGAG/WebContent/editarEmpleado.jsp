<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edicion Empleado</title>
</head>
<body>

<jsp:include page="menuEmpleado.jsp"></jsp:include>
 datos de Empleado:<br/>
 
 <form action="ServletEditarEmpleado" method="post" enctype="multipart/form-data" >

<div>
	<img src="${empleadoAEditar.rutaImagen}"  height = "200" />
	<input type="file" id="imagen" name= "campoImagen">
</div>

<div>
	<label for="nombre">Nombre</label></br>
	<input type="text" size="30" id="nombre" name="campoNombre" value="${empleadoAEditar.nombre}">
</div>
<div>
	<label for="apellidos">Apellidos</label></br>
	<input type="text" size="30" id="apellidos" name="campoApellidos" value="${empleadoAEditar.apellidos}"/>
</div>

<div>
	<label for="usuario">Usuario</label></br>
	<input type="text" size="30" id="usuario "name="campoUsuario" value="${empleadoAEditar.login}">	
</div>
<div>
	<label for="password">Password</label></br>
	<input type="password" size="30" id="password "name="campoPassword" value="${empleadoAEditar.password}">	
</div>

<div>
	<label for="comentario">Comentario</label></br>
	<textarea  rows= "4" columns= "40" id="comentario" name="campoComentario" value="${empleadoAEditar.comentario}"></textarea>
</div>


<input type="hidden" name="campoId" value="${empleadoAEditar.id}"/>
	
<input type="submit" value= "Guardar Cambios"/>

</form>
 
 
</body>
</html>