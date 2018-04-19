package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Competencia;
import daos.EmpleadosDAO;
import daosImpl.EmpleadosDAOImpl;

@WebServlet("/ServletPreparaRegistroProyecto")
public class ServletPreparaRegistroProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//validar que este logado
				
		EmpleadosDAO empleadosDAO = new EmpleadosDAOImpl();
		List<Competencia> disponibilidades = empleadosDAO.obtenerDisponibilidades();
		List<Competencia> competencias = empleadosDAO.obtenerCompetencias();
		List<Competencia> conocimientos = empleadosDAO.obtenerConocimientos();
		request.setAttribute("disponibilidades", disponibilidades);
		request.setAttribute("competencias", competencias);
		request.setAttribute("conocimientos", conocimientos);
		request.getRequestDispatcher("registrarProyecto.jsp").forward(request, response);
	}

}
