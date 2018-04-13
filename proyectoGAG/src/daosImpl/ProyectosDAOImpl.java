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
			ps.setString(1, proyecto.getNombre());
			ps.setString(2, proyecto.getComentario());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de insercion de proyecto esta mal");
			System.out.println(e.getMessage());
		}
		desconectar();
	}//fin registrar
	//listar proyectos
	public List<Proyecto> obtenerProyecto() {
		conectar();
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.SELECCION_PROYECTOS);
			ResultSet resultado =ps.executeQuery();
			
			while(resultado.next()){
				Proyecto proyecto = new Proyecto();
				proyecto.setNombre(resultado.getString("nombre"));
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
	}
	//fin de listar

}
