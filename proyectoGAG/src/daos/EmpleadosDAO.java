package daos;

import modelo.Empleado;

public interface EmpleadosDAO {
	boolean identificarEmpleado(String usuario, String pass);

	void registrarEmpleado(Empleado empleado);
}
