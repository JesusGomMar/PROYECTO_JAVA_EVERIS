<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- usamos jsp para evitar que si nos cambian la url accedan sin meter user y pass -->
<c:if test="${sessionScope.empleado == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>

<!-- hacemos las llamadas a las diferentes opciones de empleado -->
<a href = "ServletPerfilEmpleado?id=${idEmpleado}">Mi Perfil</a> </br>
<a href = "ServletLogOut">SALIR</a> </br>