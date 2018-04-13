package constantesSQL;


import java.util.List;

public class SQLDinamicas {
	//listado empleados
	public static String sqlCompetencias(List<String> idsCompetencias) {
		 
		String sql = "SELECT nombre, apellidos, comentario ,id_proyecto, id FROM tabla_empleado where id in (select id_empleado from tabla_empleado_competencia where id_competencia in (";
		String sqlFinal = sql;
		
		for (int i = 0; i < idsCompetencias.size(); i++) {
			sqlFinal += "?";// idsCategorias.get(i);
			if (i < (idsCompetencias.size() - 1)) {
				sqlFinal += ",";
			} else if(i == (idsCompetencias.size() - 1)) {
				sqlFinal += "))";
			}
		}

		System.out.println("sql formada:");
		System.out.println(sqlFinal);
		return(sqlFinal);
	}
	//fin de listado empleados
	
	//registro empleados
	public static String sqlCompetenciasRegistro(List<String> idsCompetencias) {
		 
		String sql1 = "insert into tabla_empleado (nombre, apellidos, login, password, comentario) values (?,?,?,?,?)";
		String sql2 = "insert into tabla_empleado_competencia (id_empleado, id_competencia) values (";
		String sqlFinal = sql2;
		
		for (int i = 0; i < idsCompetencias.size(); i++) {
			sqlFinal += "?";// idsCompetencias.get(i);
			if (i < (idsCompetencias.size() - 1)) {
				sqlFinal += ",";
			} else if(i == (idsCompetencias.size() - 1)) {
				sqlFinal += ")";
			}
		}

		System.out.println("sql formada:");
		System.out.println(sqlFinal);
		return(sqlFinal);
	}
	//fin de registro empleados

}
