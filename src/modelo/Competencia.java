package modelo;

public class Competencia {
	private int id;
	private String nombre;
	private String tipo;
	
	public Competencia() {
	}

	public Competencia(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Competencia [id=" + id + ", nombre=" + nombre + ", tipo="
				+ tipo + "]";
	}
}
