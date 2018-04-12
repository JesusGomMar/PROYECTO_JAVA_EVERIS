package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import constantesSQL.ConstantesSQL;
import daos.AdministradoresDAO;
import daos.GenericDAO;

public class AdministradoresDAOImpl extends GenericDAO implements AdministradoresDAO{

	@Override
	public boolean identificarAdministrador(String usuario, String pass) {
		boolean admin = false;
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.IDENTIFICACION_ADMINISTRADOR);
			ps.setString(1, usuario);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//si este if se cumple, eso es que he obtenido un resultado de base de datos
				admin = true;
			}
		} catch (SQLException e) {
			System.out.println("sql de identificacion de administrador tiene problemas");
			System.out.println(e.getMessage());
		}		
		desconectar();
		return admin;
	}
}
