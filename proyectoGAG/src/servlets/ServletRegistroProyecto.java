package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		//validar que este logado
		if(request.getSession().getAttribute("admin")==null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		String proyecto = request.getParameter("campoNombreProyecto");
		String comentario = request.getParameter("campoComentarioProyecto");
		
		//validacion
		int validar = 0;
		
		String expresionRegularProyecto="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,15}";
		Pattern patternProyecto = Pattern.compile(expresionRegularProyecto);
		Matcher matcherProyecto = patternProyecto.matcher(proyecto);
		if (matcherProyecto.matches()){}	else{
			System.out.println("error proyecto");
			request.getRequestDispatcher("registrarProyecto.jsp").forward(request, response);
			validar=1;
		}
		
		String expresionRegularComentario="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—*!?ø°\\s]{0,400}";
		Pattern patternComentario = Pattern.compile(expresionRegularComentario);
		Matcher matcherComentario = patternComentario.matcher(comentario);
		if (matcherComentario.matches()){}	else{
			System.out.println("error comentario");
			request.getRequestDispatcher("registrarProyecto.jsp").forward(request, response);
			validar=1;
		}
		
		
		if (validar==0){
		Proyecto proyectos = new Proyecto(proyecto, comentario);
		ProyectosDAO proyectosDAO = new ProyectosDAOImpl();
		proyectosDAO.registrarProyecto(proyectos);
		}else {
			request.getRequestDispatcher("registrarProyecto.jsp").forward(request, response);
		}
		
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
