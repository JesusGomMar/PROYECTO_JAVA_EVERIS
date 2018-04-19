package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			ps.setString(1, proyecto.getProyecto());
			ps.setString(2, proyecto.getComentario());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de proyecto esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}
	
		@Override
	public List<Proyecto> obtenerProyectos() {
		conectar();
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.SELECCION_PROYECTOS);
			ResultSet resultado =ps.executeQuery();
			
			while(resultado.next()){
				Proyecto proyecto = new Proyecto();
				proyecto.setProyecto(resultado.getString("proyecto"));
				proyecto.setComentario(resultado.getString("comentario"));
				proyecto.setId(resultado.getInt("id"));
				proyectos.add(proyecto);
				}
			} catch (SQLException e) {
			System.out.println("error sql listar");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		return proyectos;
	}//end obtener

		@Override
		public int obtenerIdProyecto() {
			conectar();
			int idProyecto = 0;
			
			PreparedStatement ps;
			try {
				ps = miConexion.prepareStatement(ConstantesSQL.ULTIMO_PROYECTO);
				ResultSet resultado =ps.executeQuery();
				
				while(resultado.next()){
					idProyecto= resultado.getInt("id");
					}
				} catch (SQLException e) {
				System.out.println("error sql ultimo proyecto");
				System.out.println(e.getMessage());
			}
			
			desconectar();
			return idProyecto;
			
		}

		@Override
		public void asignarProyectos(int idProyecto, List<String> ids) {
			conectar();
			try {
				PreparedStatement ps = miConexion
						.prepareStatement(ConstantesSQL.ASIGNAR_PROYECTO);
				for (String idEmpleado : ids) {
					ps.setInt(1, idProyecto);
					ps.setString(2, idEmpleado);
					System.out.println("id empleado = " +idEmpleado + "id proyecto = "+idProyecto);
					ps.execute();
				}
				
				ps.close();
			} catch (SQLException e) {
				System.out.println("la sql de insercion de proyecto esta mal");
				System.out.println(e.getMessage());
			}
			desconectar();
			
		}

		
	
}
