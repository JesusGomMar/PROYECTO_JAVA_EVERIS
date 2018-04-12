package modelo;

public class Proyecto {
	private int id;
	private String nombre;
	private String comentario;
	
	public Proyecto() {
	}

	public Proyecto(String nombre, String comentario) {
		super();
		this.nombre = nombre;
		this.comentario = comentario;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", comentario="
				+ comentario + "]";
	}
}
