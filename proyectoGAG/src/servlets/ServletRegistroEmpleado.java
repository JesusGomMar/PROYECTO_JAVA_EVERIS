package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		//validacion
		
				int validar = 0;
				
				String expresionRegularNombre="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,15}";
				Pattern patternNombre = Pattern.compile(expresionRegularNombre);
				Matcher matcherNombre = patternNombre.matcher(nombre);
				if (matcherNombre.matches()){}	else{
					System.out.println("error nombre");
					request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
					validar=1;
				}
				
				String expresionRegularApellidos="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,30}";
				Pattern patternApellidos = Pattern.compile(expresionRegularApellidos);
				Matcher matcherApellidos = patternApellidos.matcher(apellidos);
				if (matcherApellidos.matches()){}	else{
					System.out.println("error apellido");
					request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
					validar=1;
				}
		
				String expresionRegularLogin="[a-zA-Z0-9]{3,10}";
				Pattern patternLogin = Pattern.compile(expresionRegularLogin);
				Matcher matcherLogin = patternLogin.matcher(login);
				if (matcherLogin.matches()){}	else{
					System.out.println("error login");
					request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
					validar=1;
				}
				
				String expresionRegularPassword="[a-zA-Z0-9*]{3,10}";
				Pattern patternPassword = Pattern.compile(expresionRegularPassword);
				Matcher matcherPassword = patternPassword.matcher(password);
				if (matcherPassword.matches()){}	else{
					System.out.println("error password");
					request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
					validar=1;
				}
				
				String expresionRegularComentario="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—*!?ø°\\s]{0,400}";
				Pattern patternComentario = Pattern.compile(expresionRegularComentario);
				Matcher matcherComentario = patternComentario.matcher(comentario);
				if (matcherComentario.matches()){}	else{
					System.out.println("error comentario");
					request.getRequestDispatcher("registrarEmpleado.jsp").forward(request, response);
					validar=1;
				}
				
		if (validar==0){
		Empleado empleado = new Empleado(nombre, apellidos, login, password, comentario, imagen);
		empleado.setIdsCompetencias(idsCompetencias);
		System.out.println("voy a registrar mandando a un dao: " + empleado);
		
		
		
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		empleadosDAO.registrarEmpleado(empleado);
		request.setAttribute("empleado", empleado);
		request.getRequestDispatcher("registroEmpleadoOk.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("registrarProyecto.jsp").forward(request, response);
		}
	}
}
