package interfaces;

import dominio.Equipo;
import dominio.Formacion;

public interface FormacionStrategy {

    Formacion armarFormacion(Equipo e);
    public int getId();
    public void setId(int id);

}
