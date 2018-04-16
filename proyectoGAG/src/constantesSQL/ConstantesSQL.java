package constantesSQL;

public class ConstantesSQL {
	public static final String IDENTIFICACION_ADMINISTRADOR = "select id from tabla_admin where login = ? and pass = ?";
	public static final String IDENTIFICACION_EMPLEADO = "select id from tabla_empleado where login = ? and password = ?";
	public static final String INSERCION_EMPLEADO = "insert into tabla_empleado (nombre, apellidos, login, password, comentario) values (?,?,?,?,?)";
	public static final String INSERCION_PROYECTO = "insert into tabla_proyecto (proyecto, comentario) values (?,?)";
	public static final String INSERCION_COMPETENCIA = "insert into tabla_competencia (nombre, tipo) values (?,?)";
	
	public static final String SQL_SELECCION_COMPETENCIAS = "select * from tabla_competencia where tipo='transversal'";
	public static final String SQL_SELECCION_DISPONIBILIDADES = "select * from tabla_competencia where tipo='disponibilidad'";
	public static final String SQL_SELECCION_CONOCIMIENTOS = "select * from tabla_competencia where tipo='conocimiento'";
	
	public static final String ID_EMPLEADO = "SELECT id FROM tabla_empleado where login = ?";
	public static final String OBTENER_EMPLEADO_POR_ID = "select * from tabla_empleado where id = ?";
	public static final String BORRAR_EMPLEADO = "delete from tabla_empleado where id = ?";
	public static final String BORRAR_COMPETENCIAS_EMPLEADO = "delete from tabla_empleado_competencia where id_empleado = ?";

	public static final String GUARDAR_CAMBIOS_EMPLEADO = "update tabla_empleado set nombre=?, apellidos=?, login=?, password=?, comentario=? where id=?";

	public static final String INSERCION_COMPETENCIAS_EMPLEADO = "insert into tabla_empleado_competencia (id_empleado,id_competencia) values (?,?)";
	public static final String SELECCIONAR_COMPETENCIA_EMPLEADO = "SELECT nombre FROM tabla_competencia where tabla_competencia.id in (select id_competencia from tabla_empleado_competencia where id_empleado = ?) and tipo = ?";
	public static final String SELECCION_PROYECTOS = "select * from tabla_proyecto";
}
