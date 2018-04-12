package constantesSQL;

public class ConstantesSQL {
	public static final String IDENTIFICACION_ADMINISTRADOR = "select id from tabla_admin where login = ? and pass = ?";
	public static final String IDENTIFICACION_EMPLEADO = "select id from tabla_empleado where login = ? and password = ?";
	public static final String INSERCION_EMPLEADO = "insert into tabla_empleado (nombre, apellidos, login, password, comentario) values (?,?,?,?,?)";
}
