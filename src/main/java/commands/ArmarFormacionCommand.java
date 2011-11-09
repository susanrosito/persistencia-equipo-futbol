package commands;

import homes.EquipoHome;
import homes.FormacionHome;
import dominio.Equipo;
import dominio.Formacion;


public class ArmarFormacionCommand implements Runnable {
    // Buscar un equipo por nombre, pedirle que arme una formación y persistir esa formación.

    private final String nombreEquipo;

    public ArmarFormacionCommand(final String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public void run() {
        Equipo e = new EquipoHome().getByName(this.nombreEquipo);

 
        Formacion f = e.armarFormacion();
        
        new FormacionHome().save(f);

    }

}
