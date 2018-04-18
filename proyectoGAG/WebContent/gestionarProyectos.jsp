<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de Proyectos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div class="container">
	<div>
		<jsp:include page="menuAdmin.jsp"></jsp:include>
	</div>

	<h1>Edita los empleados de un proyecto:</h1>

	<form action="ServletEditarProyecto" method="post" >

		<table class="table table-bordered">

			<tr>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Borrar</th>
			</tr>
			<c:forEach items="${empleadosProyecto}" var="empleadoProyecto">
				<tr>
					<td>${empleadoProyecto.nombre}<td>
					<td>${empleadoProyecto.apellido}<td>
					<td> <button type="button" name="borrar"  onclick="ServletBorrarEmpleadoProyecto=${empleadoProyecto.id}">Borrar</button> </td>
				</tr>
			</c:forEach>

		</table>
	
		<div>
			<input type="submit" value= "Aceptar"/>
		</div>
	
</form>
<div>
		<jsp:include page="footer.jsp"></jsp:include>
</div>

</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</body>
</html>