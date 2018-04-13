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
	
	<div>
		<c:forEach items="${empleadosfiltrados}" var="empleadofiltrado">
			<div>
				<input type="checkbox" >${empleadofiltrado.nombre}
			</div>
		</c:forEach>
	</div>

</body>
</html>