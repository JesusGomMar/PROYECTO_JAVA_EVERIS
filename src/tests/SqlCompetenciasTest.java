package tests;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Empleado;
import constantesSQL.ConstantesSQL;
import constantesSQL.SQLDinamicas;

public class SqlCompetenciasTest {

	public static void main(String[] args) {

		List<String> ids = new ArrayList<>();
		ids.add("1");
		ids.add("2");
		ids.add("3");
		
		Empleado empleadoPrueba = new Empleado();
		empleadoPrueba.setIdsCompetencias(ids);		
		
		String res = SQLDinamicas.sqlCompetencias(empleadoPrueba.getIdsCompetencias());
		System.out.println("resultado: " + res);
		
		System.exit(-1);//para no seguir ejecutando, lo siguiente es solo para verlo
		
		
		PreparedStatement ps = null;
		int indice = 2;
		for (String idAregistrar : empleadoPrueba.getIdsCompetencias()) {
			try {
				ps.setInt(indice, Integer.parseInt(idAregistrar));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			indice++;
		}		
	}

}
