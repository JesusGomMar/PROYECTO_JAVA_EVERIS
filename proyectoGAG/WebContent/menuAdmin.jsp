<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- usamos jsp para evitar que si nos cambian la url accedan sin meter user y pass -->
<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<!-- hacemos las llamadas a las diferentes opciones de administracion -->
<a href = "ServletListadoEmpleados">Gestionar Empleados</a>&nbsp;
<a href = "ServletListadoProyectos">Gestionar Proyectos</a>&nbsp; </br>
<a href = "ServletListadoCompetencias">Gestionar Competencias</a>&nbsp; </br>
<a href = "ServletRegistroCompetencias">Registrar Competencias</a>&nbsp; </br>
<a href = "registroEmpleado.jsp">Registrar Empleado</a> &nbsp; </br>
<a href = "registroProyecto.jsp">Registrar Proyecto</a> &nbsp; </br>
<a href = "ServletLogOut">SALIR</a>&nbsp; </br>
