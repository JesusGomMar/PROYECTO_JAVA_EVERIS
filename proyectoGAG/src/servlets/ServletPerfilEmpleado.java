package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Competencia;
import modelo.Empleado;
import daos.EmpleadosDAO;
import daosImpl.EmpleadosDAOImpl;

@WebServlet("/ServletPerfilEmpleado")
public class ServletPerfilEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		Empleado empleado = empleadosDAO.obtenerEmpleadoPorId(id);
		System.out.println("obtener disponibilidades de id: " + id);
		List<Competencia> disponibilidades = empleadosDAO.obtenerDisponibilidades(id);
		List<Competencia> competencias = empleadosDAO.obtenerCompetencias(id);
		List<Competencia> conocimientos = empleadosDAO.obtenerConocimientos(id);
		request.setAttribute("disponibilidades", disponibilidades);
		request.setAttribute("competencias", competencias);
		request.setAttribute("conocimientos", conocimientos);
		request.setAttribute("empleado", empleado);
		request.getRequestDispatcher("perfilEmpleado.jsp").forward(request, response);
	}

}
