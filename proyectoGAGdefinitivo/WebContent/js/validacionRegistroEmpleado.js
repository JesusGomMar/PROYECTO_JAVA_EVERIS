function validacionFormularioRegistroEmpleado(){
	
	
	var enviarForm = true;
	
	// obtener lo escrito por el user 
	
	var campoNombre = document.getElementsByName("campoNombre")[0];
	var nombre = campoNombre.value;
//	alert("voy a validar: "+ nombre)
	
	var campoApellidos = document.getElementsByName("campoApellidos")[0];
	var apellidos = campoApellidos.value;
//	alert("voy a validar: "+ apellidos)
	
	var campoUsuario = document.getElementsByName("campoUsuario")[0];
	var usuario = campoUsuario.value;
//	alert("voy a validar: "+ usuario)
	
	var campoPassword = document.getElementsByName("campoPassword")[0];
	var password = campoPassword.value;
//	alert("voy a validar: "+ campoPassword)
	
	var campoComentario = document.getElementsByName("campoComentario")[0];
	var comentario = campoComentario.value;
//	alert("voy a validar: "+ comentario)
	
// como validar TODAS las entradas de las competencias???
	
	var expresionCampoNombre = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]{3,15}$/;
	var expresionCampoApellidos = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]{3,30}$/;
	var expresionCampoUsuario = /^[a-zA-Z0-9]{3,10}/;
	var expresionCampoPassword = /^[a-zA-Z0-9*]{3,10}$/;
	var expresionCampoComentario = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ*!?¿¡\s]{0,400}$/;
	
	
	if (expresionCampoNombre.test(nombre)){
//		alert("nombre ok");
	}else{
		alert("nombre ko");
		enviarForm = false;
	}
	
	if (expresionCampoApellidos.test(apellidos)){
//		alert("apellidos ok");
	}else{
		alert("apellidos ko");
		enviarForm = false;
	}
	
	if (expresionCampoUsuario.test(usuario)){
//		alert("usuario ok");
	}else{
		alert("usuario ko");
		enviarForm = false;
	}
	
	if (expresionCampoPassword.test(password)){
//		alert("password ok");
	}else{
		alert("password ko");
		enviarForm = false;
	}
	
	if (expresionCampoComentario.test(comentario)){
//		alert("comentario ok");
	}else{
		alert("comentario ko");
		enviarForm = false;
	}
	
	// devolver true si todo ok, o false si hay algo mal
	
	return enviarForm;
	
	
}