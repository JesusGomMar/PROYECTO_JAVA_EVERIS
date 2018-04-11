package constantesSQL;

public class ConstantesSQL {
	public static final String INSERCION_ADMINISTRADOR = "insert into tabla_administrador (login, pass) values (?,?)";
	public static final String IDENTIFICACION_ADMIN = "select id from tabla_administrador where login = ? and pass = ?";
}
