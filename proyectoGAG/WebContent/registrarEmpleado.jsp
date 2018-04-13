<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<form action="ServletRegistroEmpleado" method="post" enctype="multipart/form-data" >

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
	<label for="categorias">Categorias</label></br>
	Selecciona una categoria: <select name="campoCompetencia_0" onchange="listarCategorias(this);">
	<p id="categoria"></p>
		<option value = "0" checked>selecciona una opcion</option>
		<option value = "coche">coche</option>
		<option value = "avion">avion</option>
		<option value = "barco">barco</option>
	
<%--     <c:forEach items="${categorias}" var="categoria" > --%>
<%--         <option value="${categoria.id}">${categoria.nombre}</option> --%>
<!--     </c:forEach> -->
    
</select><br>
</div>

<div id="listadoCategorias">categorias: </div>



<div>
	<label for="fotografia">Fotografia:</label></br>
 	<input type="file" id="imagen" name= "campoImagen">
</div>
	
<input type="submit" value= "Aceptar"/>

</form>

<script src="./js/js.js"></script>
</body>
</html>