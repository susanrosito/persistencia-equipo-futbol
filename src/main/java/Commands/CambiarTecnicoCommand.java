package Commands;

import Clases.Equipo;
import Clases.Tecnico;
import Home.EquipoHome;
import Home.TecnicoHome;

/**
 * TODO: description
 */
public class CambiarTecnicoCommand implements Runnable {
    private final String nombreTecnico;

    private final String nombreEquipo;

    public CambiarTecnicoCommand(final String nombreEquipo, final String nombreTecnico) {
        this.nombreTecnico = nombreTecnico;
        this.nombreEquipo = nombreEquipo;
    }

    @Override
    public void run() {
        Equipo e = new EquipoHome().getByName(this.nombreEquipo);
        Tecnico t = new TecnicoHome().getByName(this.nombreTecnico);
        e.setTecnico(t);
    }

}
