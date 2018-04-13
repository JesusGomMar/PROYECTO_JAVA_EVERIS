package constantesSQL;

public class ConstantesSQL {
	public static final String IDENTIFICACION_ADMINISTRADOR = "select id from tabla_admin where login = ? and pass = ?";
	public static final String IDENTIFICACION_EMPLEADO = "select id from tabla_empleado where login = ? and password = ?";
	public static final String INSERCION_EMPLEADO = "insert into tabla_empleado (nombre, apellidos, login, password, comentario) values (?,?,?,?,?)";
	public static final String INSERCION_PROYECTO = "insert into tabla_proyecto (proyecto, comentario) values proyecto = ?, comentario = ?";
	public static final String INSERCION_COMPETENCIA = "insert into tabla_competencia (nombre, tipo) values nombre = ?, tipo = ?";
	public static final String SQL_SELECCION_COMPETENCIAS = "select * from tabla_competencia where tipo='transversal'";
	public static final String SQL_SELECCION_DISPONIBILIDADES = "select * from tabla_competencia where tipo='disponibilidad'";
	public static final String SQL_SELECCION_CONOCIMIENTOS = "select * from tabla_competencia where tipo='conocimiento'";
}
