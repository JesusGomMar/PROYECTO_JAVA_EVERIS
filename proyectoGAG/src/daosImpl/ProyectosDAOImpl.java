package daosImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import constantesSQL.ConstantesSQL;
import modelo.Proyecto;
import daos.GenericDAO;
import daos.ProyectosDAO;

public class ProyectosDAOImpl extends GenericDAO implements ProyectosDAO{

	@Override
	public void registrarProyecto(Proyecto proyecto) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.INSERCION_PROYECTO);
			ps.setString(1, proyecto.getNombre());
			ps.setString(2, proyecto.getComentario());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de proyecto esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}
}
