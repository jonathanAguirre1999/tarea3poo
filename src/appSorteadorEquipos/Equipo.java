package appSorteadorEquipos;

public class Equipo {

	//atributos de la clase
	private String nombre;
	 
	//constructores
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
	 
	public Equipo() {
		
	}

	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//toString sobreescrito
	@Override
	public String toString() {
		return this.nombre;
	}
	
}
