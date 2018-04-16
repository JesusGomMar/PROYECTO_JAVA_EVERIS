package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.Empleado;
import daos.EmpleadosDAO;
import daosImpl.EmpleadosDAOImpl;

@WebServlet("/ServletBorrarEmpleado")
public class ServletBorrarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("borrar empleado de id: " + id);
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		Empleado empleado = empleadosDAO.obtenerEmpleadoPorId(id);
		int jop = JOptionPane.showConfirmDialog(null, "Tu perfil se borrara", "Alerta!", JOptionPane.YES_NO_OPTION);
		if(jop==0){
			empleadosDAO.borrarEmpleado(id);
			empleadosDAO.borrarCompetenciasEmpleado(id);
			request.getRequestDispatcher("borradoEmpleadoOk.jsp").forward(request, response);
		}else{
			request.setAttribute("empleado", empleado);
			request.getRequestDispatcher("perfilEmpleado.jsp").forward(request, response);
		}
	}

}
