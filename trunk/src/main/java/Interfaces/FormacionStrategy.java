package Interfaces;

import Clases.Formacion;
import Clases.Equipo;

public interface FormacionStrategy {

	Formacion armarFormacion(Equipo e);
	
}
