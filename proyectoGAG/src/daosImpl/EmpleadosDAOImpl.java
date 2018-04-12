package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utilidades.GestorArchivos;

import com.mysql.jdbc.Statement;

import modelo.Empleado;
import constantesSQL.ConstantesSQL;
import daos.EmpleadosDAO;
import daos.GenericDAO;

public class EmpleadosDAOImpl extends GenericDAO implements EmpleadosDAO{

	@Override
	public boolean identificarEmpleado(String usuario, String pass) {
		boolean empleado = false;
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.IDENTIFICACION_EMPLEADO);
			ps.setString(1, usuario);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				//si este if se cumple, eso es que he obtenido un resultado de base de datos
				empleado = true;
			}
		} catch (SQLException e) {
			System.out.println("sql de identificacion de empleado tiene problemas");
			System.out.println(e.getMessage());
		}		
		desconectar();
		return empleado;
	}

	@Override
	public void registrarEmpleado(Empleado empleado) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.INSERCION_EMPLEADO, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, empleado.getLogin());
			ps.setString(4, empleado.getPassword());
			ps.setString(5, empleado.getComentario());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();//getGeneratedKeys da el id autogenerado
			if(rs.next()){
				int idGenerado = rs.getInt(1); //dame el primer elemento que devuelve getGeneratedKeys
				System.out.println("id generado en bd: " + idGenerado);
				//guardar la foto del empleado en una carpeta 
				//nombrada con el mismo id generado
				GestorArchivos.guardarArchivo(empleado.getImagenSubida(), idGenerado+".jpg");
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de empleado esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();		
	}	
}
