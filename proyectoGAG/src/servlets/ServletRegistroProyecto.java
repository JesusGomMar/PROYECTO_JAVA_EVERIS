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
import modelo.Proyecto;
import daos.EmpleadosDAO;
import daos.ProyectosDAO;
import daosImpl.EmpleadosDAOImpl;
import daosImpl.ProyectosDAOImpl;

@WebServlet("/ServletRegistroProyecto")
public class ServletRegistroProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proyecto = request.getParameter("campoNombreProyecto");
		String comentario = request.getParameter("campoComentarioProyecto");
		
		Proyecto proyectos = new Proyecto(proyecto, comentario);
		ProyectosDAO proyectosDAO = new ProyectosDAOImpl();
		proyectosDAO.registrarProyecto(proyectos);
		
		//parte de empleados
		Enumeration<String> namesRecibidos = request.getParameterNames();
		List<String> namesCamposForm = new ArrayList<>();
		List<String> valueDeCadaSelect = new ArrayList<>();
		while (namesRecibidos.hasMoreElements()) {
			namesCamposForm.add(namesRecibidos.nextElement());
		}
		for (String name : namesCamposForm) {
			System.out.println("recibi como name: " + name + " valor: " + 
					request.getParameter(name));
			if(name.startsWith("campoCompetencia_")){
				valueDeCadaSelect.add(request.getParameter(name));
			}
		}		
			
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		if(valueDeCadaSelect.size()==0){
			List<Empleado> empleados = empleadosDAO.obtenerEmpleados();
			request.setAttribute("empleados", empleados);
			request.getRequestDispatcher("listadoEmpleados.jsp").forward(request, response);
			System.out.println("NO SE HAN SELECCIONADO COMPETENCIAS");
		}else{
			List<Empleado> empleados = empleadosDAO.obtenerEmpleados(valueDeCadaSelect);
			request.setAttribute("empleados", empleados);
			request.getRequestDispatcher("listadoEmpleados.jsp").forward(request, response);
		}	
		//preparar las variables para la jsp
		
	}
}
