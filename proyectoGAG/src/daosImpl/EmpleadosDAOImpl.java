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

public class EmpleadosDAOImpl extends GenericDAO implements EmpleadosDAO{

	
	@Override
	public List<Empleado> obtenerEmpleados(List<String> valueDeCadaSelect) {
		conectar();
		List<Empleado> empleados = new ArrayList<Empleado>();
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(SQLDinamicas.sqlCompetencias(valueDeCadaSelect));
			for (int i = 1; i <= valueDeCadaSelect.size(); i++) {
				ps.setString( i , valueDeCadaSelect.get(i-1));				
			}			
			ResultSet resultado =ps.executeQuery();
			
			while(resultado.next()){
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
	}//end obtenerEmpleados
	
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
	
	@Override
	public List<Competencia> obtenerCompetencias() {
		conectar();
		List<Competencia> competencias = new ArrayList<Competencia>();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SQL_SELECCION_COMPETENCIAS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
				c.setId(rs.getInt("id"));
				competencias.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("seguramente la sql seleccion competencias transversales este mal");
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
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SQL_SELECCION_DISPONIBILIDADES);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
				c.setId(rs.getInt("id"));
				disponibilidades.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("seguramente la sql seleccion disponibilidades este mal");
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
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SQL_SELECCION_CONOCIMIENTOS);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Competencia c = new Competencia();
				c.setNombre(rs.getString("nombre"));
				c.setId(rs.getInt("id"));
				conocimientos.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("seguramente la sql seleccion conocimientos este mal");
			System.out.println(e.getMessage());
		}		
		desconectar();
		return conocimientos;
	}	
}
