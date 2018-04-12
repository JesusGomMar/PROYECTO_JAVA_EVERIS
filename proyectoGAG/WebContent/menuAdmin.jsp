<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- usamos jsp para evitar que si nos cambian la url accedan sin meter user y pass -->
<c:if test="${sessionScope.admin == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<!-- hacemos las llamadas a las diferentes opciones de administracion -->
<!-- para registrar proyecto mandamos a un jsp que mandara todo a un servlet -->
<a href = "registrarProyecto.jsp">Crear Proyecto</a>&nbsp; </br>
<!-- para listar y gestionar proyectos llamamos a un servlet q los lista y vuelca en gestionarProyectos.jsp -->
<a href = "ServletListadoProyectos">Listado Proyectos</a>&nbsp; </br>

<!-- <a href = "ServletListadoCompetencias">Gestionar Competencias</a>&nbsp; </br> opcional -->

<a href = "ServletLogOut">SALIR</a>&nbsp; </br>
