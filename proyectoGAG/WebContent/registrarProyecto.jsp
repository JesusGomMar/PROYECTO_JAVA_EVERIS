<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Proyecto</title>
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
	<select name="campoCompetenciaProyecto_0" onchange="listarDisponibilidad(this);"><br>
	<p id="disponibilidad">
		<option value = "0" checked>Selecciona disponibilidad</option>

    	<c:forEach items="${disponibilidades}" var="categoria" >
       		 <option value="${disponibilidad.id}" name="${disponibilidad.nombre}" >${disponibilidad.nombre}</option>
    	</c:forEach>
    </p>
    
</select><br>
</div>

<div id="listadoDisponibilidad">Disponibilidad horaria:<br> </div>

<div>
	<label for="transversales">Competencias Transversales:</label>
	<select name="campoCompetenciaProyecto_" onchange="listarTransversales(this);"></br>
	<p id="transversales">
		<option value = "0" checked>Selecciona Competencias</option>
	
   		<c:forEach items="${competencias}" var="competencia" >
        	<option value="${competencia.id}" name="${competencia.nombre}">${competencia.nombre}</option>
    	</c:forEach>
    </p>
    
</select><br>
</div>

<div id="listadoTransversales">Competencias Transversales:<br> </div>

<div>
	<label for="conocimientos">Conocimientos</label>
	<select name="campoCompetenciaProyecto_" onchange="listarConocimientos(this);"></br>
	<p id="conocimientos">
		<option value = "0" checked>Selecciona Conocimientos</option>
	
    	<c:forEach items="${conocimientos}" var="categoria" >
       		 <option value="${conocimiento.id}" name="${conocimiento.nombre}">${conocimiento.nombre}</option>
    	</c:forEach>
    </p>
    
</select><br>
</div>

<div id="listadoConocimientos">Conocimientos:<br> </div>

<input type="submit" value= "Siguiente"/>

<script src="./js/js.js"></script>

</body>
</html>