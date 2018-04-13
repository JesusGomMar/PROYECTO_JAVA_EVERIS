a=1;
function listarCategorias(e){
	
	var opcionSeleccionada = e.options[e.selectedIndex].value;
	alert("he seleccionado: " + opcionSeleccionada);
	
	document.getElementById("listadoCategorias").innerHTML += opcionSeleccionada+" "+
	"<input type='hidden' name='cat_"+a+"' value='"+opcionSeleccionada+"' />";//esto es para agregar informacion de la categoria seleccionada para que le llegue al servlet
	
	a++;
}

