package daos;

import java.util.List;

import modelo.Competencia;
import modelo.Empleado;

public interface EmpleadosDAO {
	boolean identificarEmpleado(String usuario, String pass);
	void registrarEmpleado(Empleado empleado);
	List<Empleado>obtenerEmpleados(List<String> valueDeCadaSelect);
	List<Competencia> obtenerCompetencias();
	List<Competencia> obtenerDisponibilidades();
	List<Competencia> obtenerConocimientos();
	int obtenerIdEmpleado(String usuario);
	Empleado obtenerEmpleadoPorId(int id);
	List<Competencia> obtenerDisponibilidades(int id);
	List<Competencia> obtenerConocimientos(int id);
	List<Competencia> obtenerCompetencias(int id);
	void borrarEmpleado(int id);
	void borrarCompetenciasEmpleado(int id);
	void guardarCambiosEmpleado(Empleado empleado);
	void registrarCompetenciasEmpleado(Empleado empleado);
	List<Empleado> obtenerEmpleados();
}
