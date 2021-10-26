package negocio;

import java.lang.reflect.Array;
import java.util.ArrayList;

import dto.EstudianteDto;
import persistencia.EstudianteDao;

//llama a ala persistencia
public class Estudiante {
	private int cedula;
	private String nombre;
	private String apellido;

	/// ArrayList materia
	public Estudiante(String nombre, String apellido, int cedula) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int agregar() {
		// llamar a la persistencia
		EstudianteDao per = new EstudianteDao();
		int ced = per.agregarEstudiante(this.getDto());
		return ced;

	}

	private EstudianteDto getDto() {
		// TODO Auto-generated method stub
		EstudianteDto est = new EstudianteDto(this.nombre, this.apellido, this.cedula);
		return est;
	}

}
