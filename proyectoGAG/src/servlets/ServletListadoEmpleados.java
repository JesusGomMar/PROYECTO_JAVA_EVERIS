package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import constantesSQL.SQLDinamicas;
import daos.EmpleadosDAO;
import daosImpl.EmpleadosDAOImpl;

@WebServlet("/servletListadoEmpleados")
public class ServletListadoEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		List<String> valueDeCadaSelect = new ArrayList<String>();
		valueDeCadaSelect.add("1");
		valueDeCadaSelect.add("2");
		valueDeCadaSelect.add("2");
		
		
		System.out.println("el usuario ha seleccionado los siguientes value de cada select:");
		for (String idCompetencia : valueDeCadaSelect) {
			System.out.println("idCompetencia seleccionado: " + idCompetencia);
		}
		//ahora mismo selects tiene un objeto de la clase SelectFormRegistroProducto
		//por cada select que tenga el formulario enviado
		
		//lo siguiente habria que hacerlo en un DAOImpl:
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		List<Empleado> empleados = empleadosDAO.obtenerEmpleados(valueDeCadaSelect);
		for (Empleado empleado : empleados) {
			System.out.println(empleado.toString());
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> namesDeLosCamposDelForm = request.getParameterNames();
		List<String> valueDeCadaSelect = new ArrayList<String>();
		while (namesDeLosCamposDelForm.hasMoreElements()) {
			String name = (String) namesDeLosCamposDelForm.nextElement();
			if(name.startsWith("campoCompentecia_")){
				valueDeCadaSelect.add(request.getParameter(name));
			}
		}
		System.out.println("el usuario ha seleccionado los siguientes value de cada select:");
		for (String idCompetencia : valueDeCadaSelect) {
			System.out.println("idCompetencia seleccionado: " + idCompetencia);
		}
		//ahora mismo selects tiene un objeto de la clase SelectFormRegistroProducto
		//por cada select que tenga el formulario enviado
		
		//lo siguiente habria que hacerlo en un DAOImpl:
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		List<Empleado> empleados = empleadosDAO.obtenerEmpleados(valueDeCadaSelect);
		request.getRequestDispatcher("listadoEmpleados.jsp").forward(request, response);
		//fin de la parte del DAOImpl
	}

}
