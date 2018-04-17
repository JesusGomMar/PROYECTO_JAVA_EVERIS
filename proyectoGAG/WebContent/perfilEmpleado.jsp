<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi perfil</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

</head>
<body>
<a href = "ServletLogOut">SALIR</a>&nbsp; <br/>
<div class="container">
	<div>
		<img src="${empleado.rutaImagen}" class="img-circle" height="200"/>
	</div>
	<div>
	Nombre:${empleado.nombre }
	</div>
	<div>
	Apellidos:${empleado.apellidos }
	</div>
	<div>
	Usuario:${empleado.login }
	</div>
	<div>
	Password:${empleado.password }
	</div>
	<div>
	Comentario:${empleado.comentario }
	</div>
	
	<div>Disponibilidad:<br> 
		<c:forEach items="${disponibilidades}" var="disponibilidad" >
	        	${disponibilidad.nombre}<br/>
	   	</c:forEach>
	</div>
	<div>Competencias Transversales:<br> 
		<c:forEach items="${competencias}" var="competencia" >
	        	${competencia.nombre}<br/>
	   	</c:forEach>
	</div>
	<div>Conocimientos:<br> 
		<c:forEach items="${conocimientos}" var="conocimiento" >
	        	${conocimiento.nombre}<br/>
	   	</c:forEach>
	</div>
	
	</div>
	<button type="button" name="borrar"  onclick="ServletBorrarEmpleado?id=${empleado.id}">BORRAR</button>
	<button type="button" name="editar"  onclick="ServletEditarEmpleado?id=${empleado.id}">EDITAR</button>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</body>
</html>