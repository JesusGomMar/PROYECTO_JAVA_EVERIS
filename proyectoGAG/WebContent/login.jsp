<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

Introduce tus datos para identificarte: <br/>

<div style="color: red">&nbsp;${mensaje}</div>

<form action="ServletIdentificacion" method="post">
	Usuario: <input type="text" name="campoUsuario"><br/>
	Contraseņa: <input type="password" name="campoPass"><br/>
	<input type="submit" value="ENTRAR"/>
</form>

</body>
</html>