package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Proyecto;
import daos.ProyectosDAO;
import daosImpl.ProyectosDAOImpl;

@WebServlet("/ServletListadoProyectos")
public class ServletListadoProyectos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProyectosDAO daoProyecto = new ProyectosDAOImpl();
		
		List<Proyecto> proyectos = daoProyecto.obtenerProyectos();
		
		request.setAttribute("proyectos", proyectos);
		System.out.println("proyecto: " +proyectos);
		
		request.getRequestDispatcher("listadoProyectos.jsp").forward(request,response);
	}

}
