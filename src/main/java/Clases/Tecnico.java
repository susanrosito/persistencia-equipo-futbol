package Clases;

import Interfaces.FormacionStrategy;
import Interfaces.Nombrable;

public class Tecnico implements Nombrable {


	private String nombre;
	private FormacionStrategy formacionStrategy;

	public Tecnico(String nombre, FormacionStrategy fs)
	{
		this.nombre=nombre;
		this.formacionStrategy=fs;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	
	public Formacion armarFormacion(Equipo e) {
		return this.formacionStrategy.armarFormacion(e);
	}

	public FormacionStrategy getFormacionStrategy() {
		return formacionStrategy;
	}

	public void setFormacionStrategy(FormacionStrategy formacionStrategy) {
		this.formacionStrategy = formacionStrategy;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
