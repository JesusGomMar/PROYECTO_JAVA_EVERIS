package modelo;

import javax.servlet.http.Part;

public class Empleado {
	private int id;
	private String nombre;
	private String apellidos;
	private String login;
	private String password;
	private String comentario;
	private Part imagenSubida;
	private String rutaImagen;
	private int idProyecto;
	
	public Empleado() {
	}

	public Empleado(String nombre, String apellidos, String login,
			String password, String comentario, Part imagenSubida) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.login = login;
		this.password = password;
		this.comentario = comentario;
		this.imagenSubida = imagenSubida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Part getImagenSubida() {
		return imagenSubida;
	}

	public void setImagenSubida(Part imagenSubida) {
		this.imagenSubida = imagenSubida;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", login=" + login + ", password=" + password
				+ ", comentario=" + comentario + ", imagenSubida="
				+ imagenSubida + ", rutaImagen=" + rutaImagen + ", idProyecto="
				+ idProyecto + "]";
	}
}
