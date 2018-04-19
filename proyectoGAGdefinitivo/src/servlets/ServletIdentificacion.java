package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AdministradoresDAO;
import daos.EmpleadosDAO;
import daosImpl.AdministradoresDAOImpl;
import daosImpl.EmpleadosDAOImpl;

@WebServlet("/ServletIdentificacion")
public class ServletIdentificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("campoUsuario");
		String pass = request.getParameter("campoPass");
		System.out.println("Voy a identificar a usuario: "+usuario+"contraseña: "+pass);
		AdministradoresDAO administradoresDAO = new AdministradoresDAOImpl();
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		if(administradoresDAO.identificarAdministrador(usuario,  pass)){
			request.getSession().setAttribute("admin", "ok");
			request.getRequestDispatcher("loginAdminOk.jsp").forward(request, response);
			System.out.println("administrador ok");
		}else if(empleadosDAO.identificarEmpleado(usuario, pass)){
			request.getSession().setAttribute("empleado", "ok");
			int idEmpleado = empleadosDAO.obtenerIdEmpleado(usuario);
			request.setAttribute("idEmpleado", idEmpleado);
			request.getRequestDispatcher("loginEmpleadoOk.jsp").forward(request, response);
			System.out.println("empleado ok");
		}else{
			request.setAttribute("mensaje", "usuario y/o pass incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
