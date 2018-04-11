package daosImpl;

import daos.EmpleadosDAO;
import daos.GenericDAO;

public class EmpleadosDAOImpl extends GenericDAO implements EmpleadosDAO{
	@Override
	public boolean identificarEmpleado(String usuario, String pass) {
		boolean identificado = false;
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.IDENTIFICACION_EMPLEADO);
			ps.setString(1, usuario);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//si este if se cumple, eso es que he obtenido un resultado de base de datos
				identificado = true;
			}
		} catch (SQLException e) {
			System.out.println("sql de identificacion de empleado tiene problemas");
			System.out.println(e.getMessage());
		}		
		desconectar();
		return identificado;
	}
}
