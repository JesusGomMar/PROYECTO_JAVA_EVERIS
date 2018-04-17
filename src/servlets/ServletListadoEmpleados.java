package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import daos.EmpleadosDAO;
import daosImpl.EmpleadosDAOImpl;

@WebServlet("/servletListadoEmpleados")

public class ServletListadoEmpleados extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletListadoEmpleado");
		List<String> valueDeCadaSelect = new ArrayList<String>();
		for (String idCompetencia : valueDeCadaSelect) {
			System.out.println("idCompetencia seleccionado: " + idCompetencia);
		}		
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		List<Empleado> empleados = empleadosDAO.obtenerEmpleados(valueDeCadaSelect);		
		//preparar las variables para la jsp
		request.setAttribute("empleados", empleados);
		request.getRequestDispatcher("listadoEmpleados.jsp").forward(request, response);
		//fin de la parte del DAOImpl
	}
}