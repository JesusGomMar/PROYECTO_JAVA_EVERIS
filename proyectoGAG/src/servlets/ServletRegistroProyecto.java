package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Proyecto;
import daos.ProyectosDAO;
import daosImpl.ProyectosDAOImpl;

@WebServlet("/ServletRegistroProyecto")
public class ServletRegistroProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String comentario = request.getParameter("campoComentario");
		
		Proyecto proyecto = new Proyecto(nombre, comentario);
		ProyectosDAO proyectosDAO = new ProyectosDAOImpl();
		proyectosDAO.registrarProyecto(proyecto);
		
		
		request.getRequestDispatcher("asignacionEmpleadoPrpyecto.jsp").forward(request, response);
	}
}