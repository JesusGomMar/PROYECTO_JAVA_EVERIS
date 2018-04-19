package modelo;

public class Proyecto {
	private int id;
	private String proyecto;
	private String comentario;
	
	public Proyecto() {
	}

	public Proyecto(String nombre, String comentario) {
		super();
		this.proyecto = nombre;
		this.comentario = comentario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", proyecto=" + proyecto
				+ ", comentario=" + comentario + "]";
	}

	
}
