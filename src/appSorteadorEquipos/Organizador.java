package appSorteadorEquipos;

import java.util.*;

public class Organizador{

	protected List <Equipo> listaEquipos = new ArrayList<>();
	private Random random = new Random();
	
	//constructor
	public Organizador() {
		
	}
	
	//getters y setters
	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
		
	
	//agrega un nuevo equipo a la lista
	public void agregarEquipo(String nombre) {
		Equipo nuevoEquipo = new Equipo(nombre);
		listaEquipos.add(nuevoEquipo);
	}
	
	//metodo que realiza el sorteo de los partidos
	public List<String> sortearPartidos() throws InvalidTeamsException{
		if(listaEquipos.size() % 2 != 0 || listaEquipos.size() == 0) {
			throw new InvalidTeamsException("El número de equipos debe ser par y mayor a 0");
		}
		
		List<Equipo> copiaListaEquipos = new ArrayList<>(this.listaEquipos);
		List<String> partidosArmados = new ArrayList<>();
		return sortearEquipos(copiaListaEquipos, partidosArmados);
	}
	
	//metodo que se encarga del emparejamiento de los equipos, metodo auxiliar a sorteoPartidos, metodo privado
	private List<String> sortearEquipos(List<Equipo> equiposRestantes, List<String> partidosArmados){
		if(equiposRestantes.isEmpty()) {
			return partidosArmados;
		}
		
		Equipo equipo1 = equiposRestantes.remove(0);
		
		int indiceRival = random.nextInt(equiposRestantes.size());
		
		Equipo equipo2 = equiposRestantes.remove(indiceRival);
		
		String partido = equipo1 + " vs " + equipo2;
		partidosArmados.add(partido);
		
		return sortearEquipos(equiposRestantes, partidosArmados);	
	}
	
}


//------------------------------- EXCEPCIONES ---------------------------------------------//
	
class InvalidTeamsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidTeamsException(String mensaje) {
		super(mensaje);
	}
}
