package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utilidades.GestorArchivos;

import com.mysql.jdbc.Statement;

import modelo.Competencia;
import modelo.Empleado;
import constantesSQL.ConstantesSQL;
import constantesSQL.SQLDinamicas;
import daos.EmpleadosDAO;
import daos.GenericDAO;

public class EmpleadosDAOImpl extends GenericDAO implements EmpleadosDAO {

	@Override
	public List<Empleado> obtenerEmpleados(List<String> valueDeCadaSelect) {
		conectar();
		List<Empleado> empleados = new ArrayList<Empleado>();

		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(SQLDinamicas
					.sqlCompetencias(valueDeCadaSelect));
			for (int i = 1; i <= valueDeCadaSelect.size(); i++) {
				ps.setString(i, valueDeCadaSelect.get(i - 1));
			}
			ResultSet resultado = ps.executeQuery();

			while (resultado.next()) {
				Empleado empleado = new Empleado();
				empleado.setNombre(resultado.getString("nombre"));
				empleado.setApellidos(resultado.getString("apellidos"));
				empleado.setComentario(resultado.getString("comentario"));
				empleado.setIdProyecto(resultado.getInt("id_proyecto"));
				empleado.setId(resultado.getInt("id"));
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			System.out.println("error sql listar");
			System.out.println(e.getMessage());
		}
		desconectar();
		return empleados;
	}// end obtenerEmpleados

	@Override
	public boolean identificarEmpleado(String usuario, String pass) {
		boolean empleado = false;
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.IDENTIFICACION_EMPLEADO);
			ps.setString(1, usuario);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// si este if se cumple, eso es que he obtenido un resultado de
				// base de datos
				empleado = true;
			}
		} catch (SQLException e) {
			System.out
					.println("sql de identificacion de empleado tiene problemas");
			System.out.println(e.getMessage());
		}
		desconectar();
		return empleado;
	}

	@Override
	public void registrarEmpleado(Empleado empleado) {
		conectar();
		try {
			PreparedStatement ps = miConexion.prepareStatement(
					ConstantesSQL.INSERCION_EMPLEADO,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, empleado.getLogin());
			ps.setString(4, empleado.getPassword());
			ps.setString(5, empleado.getComentario());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();// getGeneratedKeys da el id
			int idGenerado = 0;							// autogenerado
			if (rs.next()) {
				idGenerado = rs.getInt(1); // dame el primer elemento que
												// devuelve getGeneratedKeys
				// System.out.println("id generado en bd: " + idGenerado);
				// guardar la foto del empleado en una carpeta
				// nombrada con el mismo id generado
				GestorArchivos.guardarArchivo(empleado.getImagenSubida(),
						idGenerado + ".jpg");
			}

			// for (String idAregistrar : empleado.getIdsCompetencias()) {
			System.out.println("tam" + empleado.getIdsCompetencias().size());
			for (int i = 0; i < empleado.getIdsCompetencias().size(); i++) {
				ps = miConexion
						.prepareStatement(ConstantesSQL.INSERCION_COMPETENCIAS_EMPLEADO);
				ps.setInt(1, idGenerado);
				System.out.println("idEmpleado regitrar=" + idGenerado);
				// ps.setInt(2, Integer.parseInt(idAregistrar));
				// System.out.println("idAregistrar="+idAregistrar);
				ps.setString(2, empleado.getIdsCompetencias().get(i));
				ps.execute();
				// ps.close();
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de empleado esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

	@Override
	public List<Competencia> obtenerCompetencias() {
		conectar();
		List<Competencia> competencias = new ArrayList<Competencia>();

		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SQL_SELECCION_COMPETENCIAS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
				c.setId(rs.getInt("id"));
				competencias.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out
					.println("seguramente la sql seleccion competencias transversales este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return competencias;
	}

	@Override
	public List<Competencia> obtenerDisponibilidades() {
		conectar();
		List<Competencia> disponibilidades = new ArrayList<Competencia>();

		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SQL_SELECCION_DISPONIBILIDADES);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
				c.setId(rs.getInt("id"));
				disponibilidades.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out
					.println("seguramente la sql seleccion disponibilidades este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return disponibilidades;
	}

	@Override
	public List<Competencia> obtenerConocimientos() {
		conectar();
		List<Competencia> conocimientos = new ArrayList<Competencia>();

		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SQL_SELECCION_CONOCIMIENTOS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
				c.setId(rs.getInt("id"));
				conocimientos.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out
					.println("seguramente la sql seleccion conocimientos este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return conocimientos;
	}

	@Override
	public int obtenerIdEmpleado(String usuario) {
		conectar();
		int idEmpleado = 0;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.ID_EMPLEADO);
			ps.setString(1, usuario);
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				idEmpleado = resultado.getInt("id");
				System.out.println("idEmpleado desde obtenerIdEmpleado: "
						+ idEmpleado);
			}
			resultado.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("sql ID_EMPLEADO esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		System.out.println("id empleado EmpleadosDAOImpl=" + idEmpleado);
		return idEmpleado;
	}

	@Override
	public Empleado obtenerEmpleadoPorId(int id) {
		conectar();
		Empleado empleado = new Empleado();

		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.OBTENER_EMPLEADO_POR_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellidos(rs.getString("apellidos"));
				empleado.setLogin(rs.getString("login"));
				empleado.setPassword(rs.getString("password"));
				empleado.setComentario(rs.getString("comentario"));
				empleado.setRutaImagen(GestorArchivos.rutaArchivo(rs
						.getInt("id")));
				empleado.setId(id);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de obtener empleado por id esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return empleado;
	}

	@Override
	public List<Competencia> obtenerDisponibilidades(int id) {
		System.out.println("id: "+id);
		conectar();
		List<Competencia> disponibilidades = new ArrayList<Competencia>();

		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SELECCIONAR_COMPETENCIA_EMPLEADO);
			ps.setInt(1, id);
			ps.setString(2, "disponibilidad");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
//				c.setId(rs.getInt("id"));
				disponibilidades.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out
					.println("seguramente la sql seleccion disponibilidades este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return disponibilidades;
	}

	@Override
	public List<Competencia> obtenerConocimientos(int id) {
		conectar();
		List<Competencia> conocimientos = new ArrayList<Competencia>();

		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SELECCIONAR_COMPETENCIA_EMPLEADO);
			ps.setInt(1, id);
			ps.setString(2, "conocimiento");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
				//c.setId(rs.getInt("id"));
				conocimientos.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out
					.println("seguramente la sql seleccion conocimientos este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return conocimientos;
	}

	@Override
	public List<Competencia> obtenerCompetencias(int id) {
		conectar();
		List<Competencia> competencias = new ArrayList<Competencia>();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.SELECCIONAR_COMPETENCIA_EMPLEADO);
			ps.setInt(1, id);
			ps.setString(2, "transversal");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
				//c.setId(rs.getInt("id"));
				competencias.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out
					.println("seguramente la sql seleccion competencias transversales este mal");
			System.out.println(e.getMessage());
		}
		desconectar();
		return competencias;
	}

	public void borrarEmpleado(int id) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.BORRAR_EMPLEADO);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			GestorArchivos.borrarArchivo(id);
		} catch (SQLException e) {
			System.out.println("la sql de borrar empleado esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

	@Override
	public void borrarCompetenciasEmpleado(int id) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.BORRAR_COMPETENCIAS_EMPLEADO);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			GestorArchivos.borrarArchivo(id);
		} catch (SQLException e) {
			System.out
					.println("la sql de borrar competencias empleado esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}

	@Override
	public void guardarCambiosEmpleado(Empleado empleado) {
		conectar();
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_EMPLEADO);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellidos());
			ps.setString(3, empleado.getLogin());
			ps.setString(4, empleado.getPassword());
			ps.setString(5, empleado.getComentario());
			ps.setInt(6, empleado.getId());
			ps.execute();
			ps.close();
			GestorArchivos.guardarArchivo(empleado.getImagenSubida(),
					empleado.getId() + ".jpg");
		} catch (SQLException e) {
			System.out.println("la sql guardar cambios empleado esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();

	}

	@Override
	public void registrarCompetenciasEmpleado(Empleado empleado) {
		conectar();
		int idEmpleado = obtenerIdEmpleado(empleado.getLogin());
		try {
			// for (String idAregistrar : empleado.getIdsCompetencias()) {
			System.out.println("tam" + empleado.getIdsCompetencias().size());
			for (int i = 0; i < empleado.getIdsCompetencias().size(); i++) {
				PreparedStatement ps = miConexion
						.prepareStatement(ConstantesSQL.INSERCION_COMPETENCIAS_EMPLEADO);
				ps.setInt(1, idEmpleado);
				System.out.println("idEmpleado regitrar=" + idEmpleado);
				// ps.setInt(2, Integer.parseInt(idAregistrar));
				// System.out.println("idAregistrar="+idAregistrar);
				ps.setString(2, empleado.getIdsCompetencias().get(i));
				ps.execute();
				// ps.close();
			}
		} catch (SQLException e) {
			System.out
					.println("la sql de insercion de competencias_empleado esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();

	}

	@Override
	public List<Empleado> obtenerEmpleados() {
		conectar();
		List<Empleado> empleados = new ArrayList<Empleado>();

		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.OBTENER_EMPLEADOS);
			ResultSet resultado = ps.executeQuery();

			while (resultado.next()) {
				Empleado empleado = new Empleado();
				empleado.setNombre(resultado.getString("nombre"));
				empleado.setApellidos(resultado.getString("apellidos"));
				empleado.setComentario(resultado.getString("comentario"));
				empleado.setIdProyecto(resultado.getInt("id_proyecto"));
				empleado.setId(resultado.getInt("id"));
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			System.out.println("error sql OBTENER EMPLEADOS");
			System.out.println(e.getMessage());
		}
		desconectar();
		return empleados;
	}
}
