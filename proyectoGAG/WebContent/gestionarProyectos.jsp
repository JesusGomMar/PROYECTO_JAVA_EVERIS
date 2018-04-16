<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de Proyectos</title>
</head>
<body>

<a href = "index.jsp">volver a inicio</a><br/>

Edita los empleados de un proyecto:<br/>

<form action="ServletEditarProyecto" method="post" >

	<table >

		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Borrar</th>
		</tr>
<!-- 		<tr> -->
<!--     		<td>jose</td> -->
<!--     		<td>alonso perez</td> -->
<!--     		<td> <button type="button" name="borrar" value="jose" onclick="alert('vas a borrar a este empleado del proyecto')">Borrar</button> </td> -->
<!--   		</tr> -->
		<c:forEach items="${empleadosProyecto}" var="empleadoProyecto">
			<tr>
				<td>${empleadoProyecto.nombre}<td>
				<td>${empleadoProyecto.apellido}<td>
				<td> <button type="button" name="borrar"  onclick="borrarEmpleadoProyecto()">Borrar</button> </td>
			</tr>
		</c:forEach>

	</table>
	
	<input type="submit" value= "Aceptar"/>
	
</form>

</body>
</html>