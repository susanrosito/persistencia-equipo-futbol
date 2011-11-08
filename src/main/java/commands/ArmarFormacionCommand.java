package commands;

import homes.EquipoHome;
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

        System.out.println(e.getNombre());
        System.out.println(e.getTecnico());
        System.out.println("CALABAZA " + e.getTecnico().getFormacionStrategy());
        Formacion f = e.armarFormacion();
        System.out.println(f);
        System.out.println(f.getEquipo());
        System.out.println(e.getTecnico());
        // e.getTecnico().setFormacionStrategy(f);
    }

}
