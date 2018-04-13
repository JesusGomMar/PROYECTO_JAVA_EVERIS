package daos;

import java.util.List;

import modelo.Empleado;

public interface EmpleadosDAO {
	boolean identificarEmpleado(String usuario, String pass);
	void registrarEmpleado(Empleado empleado);
	List<Empleado>obtenerEmpleados(List<String> valueDeCadaSelect);	
}
