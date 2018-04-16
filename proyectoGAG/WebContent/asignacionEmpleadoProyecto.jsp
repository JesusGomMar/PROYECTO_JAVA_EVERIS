<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asignación de Empleado a Proyecto</title>
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
</body>
</html>