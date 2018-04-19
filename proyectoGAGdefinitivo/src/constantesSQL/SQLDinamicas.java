package constantesSQL;


import java.util.List;

public class SQLDinamicas {	
	public static String sqlCompetencias(List<String> idsCompetencias) {
		 
		String sql = "select  *,  count(te.id) as cuenta from tabla_empleado as te,tabla_empleado_competencia as tec where tec.id_empleado = te.id and tec.id_competencia in (";
		String sqlFinal = sql;
		for (int i = 0; i < idsCompetencias.size(); i++) {
			sqlFinal += "?";// idsCategorias.get(i);
			if (i < (idsCompetencias.size() - 1)) {
				sqlFinal += ",";
			} else if(i == (idsCompetencias.size() - 1)) {
				sqlFinal += ") group by te.id having cuenta = " + idsCompetencias.size() + " and id_proyecto = 0";
			}
		}
		
		System.out.println("ids competencias tamaño total= "+idsCompetencias.size());
		System.out.println("sql formada:");
		System.out.println(sqlFinal);
		return(sqlFinal);
	}

}
