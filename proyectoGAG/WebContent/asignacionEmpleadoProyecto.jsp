<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asignaci�n de Empleado a Proyecto</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

</head>
<body>
<a href = "index.jsp">volver a inicio</a><br/>

Asigna al Proyecto los empleados que cumplen los requisitos:<br/>

<form action="ServletAsignarEmpleadoProyecto" method="post" >

	<table >

		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>checkbox</th>
		</tr>
<!-- 		<tr> -->
<!--     		<td>jose</td> -->
<!--     		<td>alonso perez</td> -->
<!--     		<td> <input type ="checkbox" name="checkbox" value="jose"> </td> -->
<!--   		</tr> -->
		<c:forEach items="${empleadosfiltrados}" var="empleadofiltrado">
			<tr>
				<td>${empleadofiltrado.nombre}<td>
				<td>${empleadofiltrado.apellido}<td>
				<td> <input type ="checkbox" name="checkbox" value="${empleadofiltrado.id}"> </td>
			</tr>
		</c:forEach>

	</table>
	
	<input type="submit" value= "Aceptar"/>
	
</form>	

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>