function validacionFormularioRegistroProyecto(){
	
	
	var enviarForm = true;
	
	// obtener lo escrito por el user 
	
	var campoNombreProyecto = document.getElementsByName("campoNombreProyecto")[0];
	var nombreProyecto = campoNombreProyecto.value;
//	alert("voy a validar: "+ nombreProyecto)
	
	var campoComentarioProyecto = document.getElementsByName("campoComentarioProyecto")[0];
	var comentarioProyecto = campoComentarioProyecto.value;
//	alert("voy a validar: "+ comentarioProyecto)
	
	
// como validar TODAS las entradas de las competencias???
	
	var expresionCampoNombreProyecto = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,15}$/;
	var expresionCampoComentarioProyecto = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{0,300}$/;
	
	
	if (expresionCampoNombreProyecto.test(nombreProyecto)){
//		alert("nombreProyecto ok");
	}else{
		alert("nombreProyecto ko");
		enviarForm = false;
	}
	
	if (expresionCampoComentarioProyecto.test(comentarioProyecto)){
//		alert("comentarioProyecto ok");
	}else{
		alert("comentarioProyecto ko");
		enviarForm = false;
	}
	
	
	// devolver true si todo ok, o false si hay algo mal
	
	return enviarForm;
	
	
}