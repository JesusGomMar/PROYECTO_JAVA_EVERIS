<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Proyecto</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

</head>
<body>

<a href = "index.jsp">volver a inicio</a><br/>

Introduce nombre del Proyecto:<br/>
<form action="ServletRegistroProyecto" method="post" >

<div>
	<label for="nombre">Nombre</label></br>
	<input type="text" size="30" id="nombreProyecto" name="campoNombreProyecto" placeholder="Nombre del Proyecto">
</div>

<div>
	<label for="comentario">Comentario</label></br>
	<textarea  rows= "4" columns= "40" id="comentarioProyecto" name="campoComentarioProyecto"placeholder="Comentario"></textarea>
</div>

<p>Requisitos Proyecto</p>

<div>
	<label for="disponibilidad">Disponibilidad Horaria</label>
	<select name="campoDisponibilidad" onchange="listarDisponibilidad(this);"><br>
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
	<select name="campoTransversales" onchange="listarTransversales(this);"></br>
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
	<select name="campoConocimiento" onchange="listarConocimientos(this);"></br>
	<p id="conocimientos"></p>
		<option value = "0" checked>Selecciona Conocimientos</option>
	
    	<c:forEach items="${conocimientos}" var="conocimiento" >
       		 <option value="${conocimiento.id}" id = "${conocimiento.nombre}">${conocimiento.nombre}</option>
    	</c:forEach>
    
</select><br>
</div>

<div id="listadoConocimientos">Conocimientos:<br> </div>

<input type="submit" value= "Siguiente"/>

<script src="./js/js.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</body>
</html>