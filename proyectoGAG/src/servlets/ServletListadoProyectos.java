package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProyectosDAO;
import daosImpl.ProyectosDAOImpl;

@WebServlet("/ServletListarProyectos")
public class ServletListadoProyectos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProyectosDAO daoProyecto = new ProyectosDAOImpl();
		
		request.setAttribute("proyectos", daoProyecto.obtenerProyecto());
		
		request.getRequestDispatcher("listadoProyectos.jsp").forward(request,response);
	}

}
