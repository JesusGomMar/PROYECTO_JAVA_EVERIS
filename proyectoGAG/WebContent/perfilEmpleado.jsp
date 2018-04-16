<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi perfil</title>
</head>
<body>
<a href = "ServletLogOut">SALIR</a>&nbsp; <br/>
<div>
	<div>
		<img src="${empleado.rutaImagen}" height="200"/>
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
	<a href="ServletBorrarEmpleado?id=${empleado.id}">BORRAR</a>
 		
 	<a href="ServletEditarEmpleado?id=${empleado.id}">EDITAR</a>

</body>
</html>