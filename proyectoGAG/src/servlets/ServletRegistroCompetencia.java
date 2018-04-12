package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Competencia;
import daos.CompetenciasDAO;
import daosImpl.CompetenciasDAOImpl;

@WebServlet("/ServletRegistroCompetencia")
public class ServletRegistroCompetencia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String tipo = request.getParameter("campoTipo");
		
		Competencia competencia = new Competencia(nombre, tipo);
		CompetenciasDAO competenciasDAO = new CompetenciasDAOImpl();
		competenciasDAO.registrarCompetencia(competencia);
		
		request.getRequestDispatcher("registroCompetenciaOk.jsp").forward(request, response);
	}

}
