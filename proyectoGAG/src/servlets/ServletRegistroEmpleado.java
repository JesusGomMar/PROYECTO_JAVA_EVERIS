package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import daos.EmpleadosDAO;
import daosImpl.EmpleadosDAOImpl;
import modelo.Empleado;

@WebServlet("/ServletRegistroEmpleado")
public class ServletRegistroEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String apellidos = request.getParameter("campoApellidos");
		String login = request.getParameter("campoLogin");	
		String password = request.getParameter("campoPassword");
		String comentario = request.getParameter("campoComentario");
		Part imagen = request.getPart("campoImagen");

		Empleado empleado = new Empleado(nombre, apellidos, login, password, comentario, imagen);
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		empleadosDAO.registrarEmpleado(empleado);
		request.getRequestDispatcher("registroEmpleadoOk.jsp").forward(request, response);
	}

}
