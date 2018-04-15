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
<a href = "menuEmpleado.jsp">volver a inicio</a><br/>

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
	<label for="disponibilidad">Disponibilidad Horaria</label>
	<select name="campoCompetencia_0" onchange="listarDisponibilidad(this);"><br>
	<p id="disponibilidad"></p>
		<option value = "0" checked>Selecciona disponibilidad</option>	
    	<c:forEach items="${disponibilidades}" var="disponibilidad" >
       		 <option value="${disponibilidad.id}" id = "${disponibilidad.nombre}">${disponibilidad.nombre}</option>
    	</c:forEach>
    
</select><br>
</div>

<div id="listadoDisponibilidad">Disponibilidad:<br> </div>

<div>
	<label for="transversales">Competencias Transversales:</label>
<!-- 	ojo con el name, tiene que continuar en el campocompetencia anterior -->
	<select name="campoCompetencia_" onchange="listarTransversales(this);"></br>
	<p id="transversales"></p>
		<option value = "0" checked>Selecciona Competencias</option>	
   		<c:forEach items="${competencias}" var="competencia" >
        	<option value="${competencia.id}" id = "${competencia.nombre}">${competencia.nombre}</option>
    	</c:forEach>
    
</select><br>
</div>

<div id="listadoTransversales">Competencias Transversales:<br> </div>

<div>
	<label for="conocimientos">Conocimientos</label>
<!-- 	ojo con el name, tiene que continuar en el campocompetencia anterior -->
	<select name="campoCompetencia_" onchange="listarConocimientos(this);"></br>
	<p id="conocimientos"></p>
		<option value = "0" checked>Selecciona Conocimientos</option>
	
    	<c:forEach items="${conocimientos}" var="conocimiento" >
       		 <option value="${conocimiento.id}" id = "${conocimiento.nombre}">${conocimiento.nombre}</option>
    	</c:forEach>
    
</select><br>
</div>

<div id="listadoConocimientos">Conocimientos:<br> </div>



<div>
	<label for="fotografia">Fotografia:</label></br>
 	<input type="file" id="imagen" name= "campoImagen">
</div>
	
<input type="submit" value= "Aceptar"/>

</form>

<script src="./js/js.js"></script>
</body>
</html>