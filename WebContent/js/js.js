a=3;
function listarDisponibilidad(e){
	
	var opcionSeleccionada = e.options[e.selectedIndex].id;
	var idSeleccionada = e.options[e.selectedIndex].value;
	//alert("he seleccionado: " + opcionSeleccionada);
	
	document.getElementById("listadoDisponibilidad").innerHTML += opcionSeleccionada+" "+
	//esto es para agregar informacion de la categoria seleccionada para que le llegue al servlet
	
	"<input type='hidden' name='campoCompetencia_"+a+"' value='"+idSeleccionada+"' /><br>";
	a++;
}

function listarTransversales(e){
	var opcionSeleccionada = e.options[e.selectedIndex].id;
	var idSeleccionada = e.options[e.selectedIndex].value;
	//alert("he seleccionado: " + opcionSeleccionada);
	
	document.getElementById("listadoTransversales").innerHTML += opcionSeleccionada+" "+
	//esto es para agregar informacion de la categoria seleccionada para que le llegue al servlet
	
	"<input type='hidden' name='campoCompetencia_"+a+"' value='"+idSeleccionada+"' /></br>";
	a++;
	
}

function listarConocimientos(e){
	var opcionSeleccionada = e.options[e.selectedIndex].id;
	var idSeleccionada = e.options[e.selectedIndex].value;
	//alert("he seleccionado: " + opcionSeleccionada);
	
	document.getElementById("listadoConocimientos").innerHTML += opcionSeleccionada+" "+
	//esto es para agregar informacion de la categoria seleccionada para que le llegue al servlet
	
	"<input type='hidden' name='campoCompetencia_"+a+"' value='"+idSeleccionada+"' /></br>";
	a++;
	
}
