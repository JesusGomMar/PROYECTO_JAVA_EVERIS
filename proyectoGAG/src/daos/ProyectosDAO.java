package daos;

import java.util.List;

import modelo.Proyecto;

public interface ProyectosDAO {

	void registrarProyecto(Proyecto proyecto);
	List<Proyecto>obtenerProyecto();
}
