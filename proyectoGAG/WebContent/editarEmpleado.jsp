<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edicion Empleado</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

</head>
<body>
<div class="container">
	<div>
		<jsp:include page="menuEmpleado.jsp"></jsp:include>
	</div>
	<div>
		<h1> Datos de Empleado:</h1>
	</div>
 
 	<form action="ServletGuardarCambiosEmpleado" method="post" enctype="multipart/form-data" >

	<div class="form-group">
		<img src="${empleadoAEditar.rutaImagen}" class="img-circle" height = "200" /><br>
		<input type="file" id="imagen" name= "campoImagen">
	</div>

	<div class="form-group">
		<label for="nombre">Nombre</label></br>
		<input type="text" size="30" id="nombre" name="campoNombre" value="${empleadoAEditar.nombre}">
	</div>
	<div class="form-group">
		<label for="apellidos">Apellidos</label></br>
		<input type="text" size="30" id="apellidos" name="campoApellidos" value="${empleadoAEditar.apellidos}"/>
	</div>

	<div class="form-group">
		<label for="usuario">Usuario</label></br>
		<input type="text" size="30" id="usuario "name="campoUsuario" value="${empleadoAEditar.login}">	
	</div>

	<div class="form-group">
		<label for="password">Password</label></br>
		<input type="password" size="30" id="password "name="campoPassword" value="${empleadoAEditar.password}">	
	</div>

	<div class="form-group">
		<label for="disponibilidad">Disponibilidad Horaria</label>
		<select name="campoCompetencia_0" onchange="listarDisponibilidad(this);"><br>
		<p id="disponibilidad">
			<option value = "0" checked>Selecciona disponibilidad</option>

		   	<c:forEach items="${disponibilidades}" var="disponibilidad" >
	      		 <option value="${disponibilidad.id}" id="${disponibilidad.nombre}">${disponibilidad.nombre}</option>
  		  	</c:forEach>
  		</p>
    
		</select><br>
	</div>

	<div id="listadoDisponibilidad">Disponibilidad horaria:<br>
		<c:forEach items="${disponibilidad}" var="disponibilidad_empl" >
			<c:if test="${disponibilidad_empl!= null}">
       		 	<div>${disponibilidad_empl.nombre} 
      			 	<button type="button" name="borrar"  onclick="ServletBorrarCompetencia=${disponibilidad_empl.id}">BORRAR</button>
       			 </div>
       			 
       		 </c:if>
		</c:forEach>

 	</div>

	<div class="form-group">
		<label for="transversales">Competencias Transversales:</label>
		<select name="campoCompetencia_" onchange="listarTransversales(this);"></br>
		<p id="transversales">
			<option value = "0" checked>Selecciona Competencias</option>
	
   			<c:forEach items="${competencias}" var="competencia" >
   		     	<option value="${competencia.id}" id="${competencia.nombre}">${competencia.nombre}</option>
   		 	</c:forEach>
  		 </p>
    
		</select><br>
	</div>

	<div id="listadoTransversales">Competencias Transversales:<br> 
		
		<c:forEach items="${competencia}" var="competencia_empl" >
		<c:if test="${competencia_empl!=null}">
       		 <div>${competencia_empl.nombre}
       		 	
       		 	<button type="button" name="borrar"  onclick="ServletBorrarCompetencia=${competencia_empl.id}">BORRAR</button>
       		 </div>
       	</c:if>
		</c:forEach>
	</div>

	<div class="form-group">
		<label for="conocimientos">Conocimientos</label>
		<select name="campoCompetencia_" onchange="listarConocimientos(this);"></br>
		<p id="conocimientos">
			<option value = "0" checked>Selecciona Conocimientos</option>
	
    		<c:forEach items="${conocimientos}" var="conocimiento" >
    	   		 <option value="${conocimiento.id}" id="${conocimiento.nombre}">${conocimiento.nombre}</option>
    		</c:forEach>
	    </p>
    
		</select><br>
	</div>

	<div id="listadoConocimientos">Conocimientos:<br> 
		<c:forEach items="${conocimiento}" var="conocimiento_empl" >
		<c:if test="${conocimiento_empl!= null}">
       		 <div>${conocimiento_empl.nombre} 
       		 	<button type="button" name="borrar"  onclick="ServletBorrarCompetencia=${conocimiento_empl.id}">BORRAR</button>
       		 </div>
       	</c:if>
		</c:forEach>
	</div>


	<div class="form-group">
		<label for="comentario">Comentario</label></br>
		<textarea  rows= "4" columns= "40" id="comentario" name="campoComentario" ><c:out value="${empleadoAEditar.comentario}"></c:out></textarea>
	</div>

	<div class="form-group">
		<input type="hidden" name="campoId" value="${empleadoAEditar.id}"/>
	</div>
	<div class="form-group">
		<input type="submit" value= "Guardar Cambios"/>
	</div>

</form>
</div>
 
 <script src="./js/js.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>