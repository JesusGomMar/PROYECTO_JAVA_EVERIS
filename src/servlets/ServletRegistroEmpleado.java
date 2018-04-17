package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import daos.EmpleadosDAO;
import daosImpl.EmpleadosDAOImpl;
import modelo.Empleado;

@WebServlet("/ServletRegistroEmpleado")
@MultipartConfig
public class ServletRegistroEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//asi puedo recoger todos los campos que he recibido del formulario
		Enumeration<String> namesRecibidos = request.getParameterNames();
		List<String> namesCamposForm = new ArrayList<>();
		List<String> idsCompetencias = new ArrayList<>();
		while (namesRecibidos.hasMoreElements()) {
			namesCamposForm.add(namesRecibidos.nextElement());
		}
		//vamso a ver si es cierto;
		for (String name : namesCamposForm) {
			System.out.println("recibi como name: " + name + " valor: " + 
					request.getParameter(name));
			if(name.startsWith("campoCompetencia_")){
				idsCompetencias.add(request.getParameter(name));
			}
		}		
		
		String nombre = request.getParameter("campoNombre");
		String apellidos = request.getParameter("campoApellidos");
		String login = request.getParameter("campoUsuario");	
		String password = request.getParameter("campoPassword");
		String comentario = request.getParameter("campoComentario");
		Part imagen = request.getPart("campoImagen");

		Empleado empleado = new Empleado(nombre, apellidos, login, password, comentario, imagen);
		empleado.setIdsCompetencias(idsCompetencias);
		System.out.println("voy a registrar mandando a un dao: " + empleado);
		
		
		
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		empleadosDAO.registrarEmpleado(empleado);
		request.setAttribute("empleado", empleado);
		request.getRequestDispatcher("registroEmpleadoOk.jsp").forward(request, response);
	}
}
