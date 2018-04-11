package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDAO {

	protected Connection miConexion = null; 
	// carga del driver de conexion con JDBC:
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el driver-libreria de mysql");
		}
	}// end static

	// metodo que se va a encargar de hacer la conexion con la bbdd
	protected void conectar() {
		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_gag", "root",
					"jeveris");
		} catch (SQLException e) {
			System.out.println("no pude conectarme a la bbdd");
			System.out.println("comprobar ruta de la bbdd");
			System.out.println("comprobar nombre usuario y contraseña");
		}
	}// end conectar

	// metodo para desconectarnos de la bbdd
	protected void desconectar() {
		try {
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("no pude realizar la desconexion de la bbdd");
		}
	}// end desconectar

}// end class
