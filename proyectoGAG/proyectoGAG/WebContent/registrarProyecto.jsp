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
<input type="submit" value= "Siguiente"/>

</body>
</html>