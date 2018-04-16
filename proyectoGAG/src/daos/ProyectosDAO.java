package daos;

import modelo.Proyecto;

public interface ProyectosDAO {

	void registrarProyecto(Proyecto proyecto);
	List<Proyecto>obtenerProyectos();
}
