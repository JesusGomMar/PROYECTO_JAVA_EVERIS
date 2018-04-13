<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edicion Empleado</title>
</head>
<body>

<%-- <jsp:include page="menuEmpleado.jsp"></jsp:include> --%>
 Datos de Empleado:<br/>
 
 <form action="ServletEditarEmpleado" method="post" enctype="multipart/form-data" >

<div>
	<img src="${empleadoAEditar.rutaImagen}"  height = "200" /><br>
	<input type="file" id="imagen" name= "campoImagen">
</div>

<div>
	<label for="nombre">Nombre</label></br>
	<input type="text" size="30" id="nombre" name="campoNombre" value="${empleadoAEditar.nombre}">
</div>
<div>
	<label for="apellidos">Apellidos</label></br>
	<input type="text" size="30" id="apellidos" name="campoApellidos" value="${empleadoAEditar.apellidos}"/>
</div>

<div>
	<label for="proyecto">Proyecto</label></br>
	<input type="text" size="30" id="proyecto" name="campoProyecto" value="${empleadoAEditar.proyecto}"/>
</div>

<div>
	<label for="usuario">Usuario</label></br>
	<input type="text" size="30" id="usuario "name="campoUsuario" value="${empleadoAEditar.login}">	
</div>

<div>
	<label for="disponibilidad">Disponibilidad Horaria</label>
	<select name="campoCompetencia_0" onchange="listarDisponibilidad(this);"><br>
	<p id="disponibilidad">
		<option value = "0" checked>Selecciona disponibilidad</option>

    	<c:forEach items="${disponibilidades}" var="disponibilidad" >
       		 <option value="${disponibilidad.id}" name="${disponibilidad.nombre}">${disponibilidad.nombre}</option>
    	</c:forEach>
    </p>
    
</select><br>
</div>

<div id="listadoDisponibilidad">Disponibilidad horaria:<br>
		<c:forEach items="${disponibilidad}" var="disponibilidad_empl" >
       		 <p value="${disponibilidad_empl.id}" action= "ServletBorrarCompetencia">${disponibilidad_empl.nombre}</p>
       		 <input type="submit" value= "Borrar"/>
		</c:forEach>

 </div>

<div>
	<label for="transversales">Competencias Transversales:</label>
	<select name="campoCompetencia_" onchange="listarTransversales(this);"></br>
	<p id="transversales">
		<option value = "0" checked>Selecciona Competencias</option>
	
   		<c:forEach items="${competencias}" var="competencia" >
        	<option value="${competencia.id}" name="${competencia.nombre}">${competencia.nombre}</option>
    	</c:forEach>
    </p>
    
</select><br>
</div>

<div id="listadoTransversales">Competencias Transversales:<br> 
		<c:forEach items="${competencia}" var="competencia_empl" >
       		 <p value="${competencia_empl.id}" action= "ServletBorrarCompetencia" >${competencia_empl.nombre}</p>
       		 <input type="submit" value= "Borrar"/>
		</c:forEach>
</div>

<div>
	<label for="conocimientos">Conocimientos</label>
	<select name="campoCompetencia_" onchange="listarConocimientos(this);"></br>
	<p id="conocimientos">
		<option value = "0" checked>Selecciona Conocimientos</option>
	
    	<c:forEach items="${conocimientos}" var="conocimiento" >
       		 <option value="${conocimiento.id}" name="${conocimiento.nombre}">${conocimiento.nombre}</option>
    	</c:forEach>
    </p>
    
</select><br>
</div>

<div id="listadoConocimientos">Conocimientos:<br> 
		<c:forEach items="${conocimiento}" var="categoria" >
       		 <p value="${conocimiento_empl.id}" action= "ServletBorrarCompetencia">${conocimiento_empl.nombre}
       		 <input type="submit" value= "Borrar"/>
       		 </p>
		</c:forEach>
</div>


<div>
	<label for="comentario">Comentario</label></br>
	<textarea  rows= "4" columns= "40" id="comentario" name="campoComentario" value="${empleadoAEditar.comentario}"></textarea>
</div>


<input type="hidden" name="campoId" value="${empleadoAEditar.id}"/>
	
<input type="submit" value= "Guardar Cambios"/>

</form>
 
 <script src="./js/js.js"></script>
</body>
</html>