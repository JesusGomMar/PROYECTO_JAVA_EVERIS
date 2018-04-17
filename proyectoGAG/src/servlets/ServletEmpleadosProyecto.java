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

import daos.ProyectosDAO;
import daosImpl.ProyectosDAOImpl;

@WebServlet("/ServletEmpleadosProyecto")
public class ServletEmpleadosProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProyecto;
		Enumeration<String> namesRecibidos = request.getParameterNames();
		List<String> namesCamposForm = new ArrayList<>();
		List<String> ids = new ArrayList<String>();
		while (namesRecibidos.hasMoreElements()) {
			namesCamposForm.add(namesRecibidos.nextElement());
		}
		
		for (String name : namesCamposForm) {
			System.out.println("recibi como name: " + name + " valor: " + 
					request.getParameter(name));
			if(name.startsWith("checkBox_")){
				ids.add(request.getParameter(name));
			}
		}	
		
		ProyectosDAO proyectosDAO = new ProyectosDAOImpl();
		idProyecto = proyectosDAO.obtenerIdProyecto();
		System.out.println("id proyecto = "+idProyecto);
		
		proyectosDAO.asignarProyectos(idProyecto, ids);
	}
}
