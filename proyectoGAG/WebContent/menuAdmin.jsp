<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

<!-- usamos jsp para evitar que si nos cambian la url accedan sin meter user y pass -->
<%-- <c:if test="${sessionScope.admin == null}"> --%>
<%-- 	<jsp:forward page="login.jsp"></jsp:forward> --%>
<%-- </c:if> --%>

<!-- hacemos las llamadas a las diferentes opciones de administracion -->
<!-- para registrar proyecto mandamos a un jsp que mandara todo a un servlet -->
<a href = "registrarProyecto.jsp">Crear Proyecto</a>&nbsp; </br>
<!-- para listar y gestionar proyectos llamamos a un servlet q los lista y vuelca en gestionarProyectos.jsp -->
<a href = "ServletListadoProyectos">Listado Proyectos</a>&nbsp; </br>

<!-- <a href = "ServletListadoCompetencias">Gestionar Competencias</a>&nbsp; </br> opcional -->

<a href = "ServletLogOut">SALIR</a>&nbsp; </br>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
