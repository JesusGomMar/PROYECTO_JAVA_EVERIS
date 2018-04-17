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

@WebServlet("/ServletEditarEmpleado")
public class ServletEditarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		Empleado empleadoAEditar = empleadosDAO.obtenerEmpleadoPorId(id);
		List<Competencia> disponibilidades = empleadosDAO.obtenerDisponibilidades();
		List<Competencia> competencias = empleadosDAO.obtenerCompetencias();
		List<Competencia> conocimientos = empleadosDAO.obtenerConocimientos();
		List<Competencia> disponibilidad = empleadosDAO.obtenerDisponibilidades(id);
		List<Competencia> competencia = empleadosDAO.obtenerCompetencias(id);
		List<Competencia> conocimiento = empleadosDAO.obtenerConocimientos(id);
		request.setAttribute("disponibilidad", disponibilidad);
		request.setAttribute("competencia", competencia);
		request.setAttribute("conocimiento", conocimiento);
		System.out.println("conocimiento="+conocimiento);
		request.setAttribute("disponibilidades", disponibilidades);
		request.setAttribute("competencias", competencias);
		request.setAttribute("conocimientos", conocimientos);
		System.out.println("conocimientos="+conocimientos);
		request.setAttribute("empleadoAEditar", empleadoAEditar);
		request.getRequestDispatcher("editarEmpleado.jsp").forward(request, response);
	}
}
