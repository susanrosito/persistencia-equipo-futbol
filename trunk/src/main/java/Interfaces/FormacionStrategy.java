package Interfaces;

import dominio.Equipo;
import dominio.Formacion;

public interface FormacionStrategy {

	Formacion armarFormacion(Equipo e);
	
}
