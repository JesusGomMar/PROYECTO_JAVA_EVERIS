<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Empleados</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

</head>
<body>
<div class="container">
	<div class="form-group">
		<h1>Listado de Empleados</h1>
	</div>

	<form action="ServletEmpleadosProyecto" method="post" >

		<table class="table table-bordered">
			<tr>
				<th>Fotografia</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>checkbox</th>
			</tr>
			<c:forEach items="${empleados}" var="listadoEmpleado">
				<tr>
					<td><img src="${listadoEmpleado.rutaImagen}" class="img-circle" height = "200" /></td>
					<td>${listadoEmpleado.nombre}<td>
					<td>${listadoEmpleado.apellidos}<td>
					<td> <input type ="checkbox" name="checkbox" value="${listadoEmpleado.id}"> </td>
				</tr>
			</c:forEach>

		</table>
		<input type="hidden" name="campoId" value="${proyecto.id}"/>
	
		<div class="form-group">
			<input type="submit" value= "Aceptar"/>
		</div>

</form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</body>
</html>