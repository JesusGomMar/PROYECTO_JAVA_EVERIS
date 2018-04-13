<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de Empleados</title>
</head>
<body>

<%-- <jsp:include page="menuAdmin.jsp"></jsp:include> --%>

<c:forEach items="${empleados}" var="empleado">

	<div>
		<div>
		Nombre:${empleado.nombre }
		</div>
		<div>
		Apellidos:${empleado.apellidos }
		</div>
		<div>
	
	
	</div>
	<a href="ServletBorrarEmpleado?id=${empleado.id}">BORRAR</a>
 		
 	<a href="ServletEditarEmpleado?id=${empleado.id}">EDITAR</a>

</c:forEach>

</body>
</html>