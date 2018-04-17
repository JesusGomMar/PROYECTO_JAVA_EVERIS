package daosImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import constantesSQL.ConstantesSQL;
import modelo.Competencia;
import daos.CompetenciasDAO;
import daos.GenericDAO;

public class CompetenciasDAOImpl extends GenericDAO implements CompetenciasDAO{

	@Override
	public void registrarCompetencia(Competencia competencia) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.INSERCION_COMPETENCIA);
			ps.setString(1, competencia.getNombre());
			ps.setString(2, competencia.getTipo());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de competencia esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}
}