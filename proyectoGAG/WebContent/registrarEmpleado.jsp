<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro Empleado</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>

<div class="container">
	<div>
		<jsp:include page="menuEmpleado.jsp"></jsp:include>
	</div>

	<h1>Introduce los datos de Empleado:</h1>
	<form action="ServletRegistroEmpleado" method="post" enctype="multipart/form-data" >
	onsubmit="return validacionFormularioRegistroEmpleado()"

	<div class="form-group">
		<label for="nombre">Nombre</label></br>
		<input type="text" size="30" id="nombre" name="campoNombre" placeholder="Nombre">
	</div>
	<div class="form-group">
		<label for="apellidos">Apellidos</label></br>
		<input type="text" size="30" id="apellidos" name="campoApellidos" placeholder="Apellidos"/>
	</div>

	<div class="form-group">
		<label for="usuario">Usuario</label></br>
		<input type="text" size="30" id="usuario "name="campoUsuario" placeholder="Usuario">	
	</div>
	<div class="form-group">
		<label for="password">Password</label></br>
		<input type="password" size="30" id="password "name="campoPassword" placeholder="Contraseña">	
	</div>

	<div class="form-group">
		<label for="comentario">Comentario</label></br>
		<textarea  rows= "4" columns= "40" id="comentario" name="campoComentario"placeholder="Comentario"></textarea>
	</div>

	<div class="form-group">
		<label for="disponibilidad">Disponibilidad Horaria</label>
		<select name="campoCompetencia_0" onchange="listarDisponibilidad(this);"><br>
		<p id="disponibilidad">
			<option value = "0" checked>Selecciona disponibilidad</option>

    		<c:forEach items="${disponibilidades}" var="disponibilidad" >
     	  		 <option value="${disponibilidad.id}" id="${disponibilidad.nombre}">${disponibilidad.nombre}</option>
    		</c:forEach>
   		</p>
    
		</select><br>
	</div>

	<div id="listadoDisponibilidad">Disponibilidad horaria:<br> </div>

	<div class="form-group">
		<label for="transversales">Competencias Transversales:</label>
		<select name="campoCompetencia_" onchange="listarTransversales(this);"></br>
		<p id="transversales">
			<option value = "0" checked>Selecciona Competencias</option>
	
  			<c:forEach items="${competencias}" var="competencia" >
  		      	<option value="${competencia.id}" id="${competencia.nombre}">${competencia.nombre}</option>
  		 	</c:forEach>
   		</p>
    
		</select><br>
	</div>

	<div id="listadoTransversales">Competencias Transversales: </div>

	<div class="form-group">
		<label for="conocimientos">Conocimientos</label>
		<select name="campoCompetencia_" onchange="listarConocimientos(this);"></br>
		<p id="conocimientos">
			<option value = "0" checked>Selecciona Conocimientos</option>
	
    		<c:forEach items="${conocimientos}" var="conocimiento" >
  	     		 <option value="${conocimiento.id}" id="${conocimiento.nombre}">${conocimiento.nombre}</option>
 		   	</c:forEach>
   		</p>
    
		</select><br>
	</div>

	<div id="listadoConocimientos">Conocimientos: </div>



	<div class="form-group">
		<label for="fotografia">Fotografia:</label></br>
 		<input type="file" id="imagen" name= "campoImagen">
	</div>
	
	<input type="submit" value= "Aceptar"/>

</form>
</div>
<script src="./js/js.js"></script>
<script src="./js/validacionRegistroEmpleado.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script></body>
</html>