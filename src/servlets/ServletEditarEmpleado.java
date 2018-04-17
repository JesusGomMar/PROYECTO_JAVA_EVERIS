package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setAttribute("empleadoAEditar", empleadoAEditar);
		request.getRequestDispatcher("editarEmpleado.jsp").forward(request, response);
	}
}
