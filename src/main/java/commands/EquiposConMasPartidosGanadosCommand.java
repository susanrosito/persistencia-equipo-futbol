package commands;

import homes.PartidoDeCopaHome;

import java.util.ArrayList;

import dominio.Equipo;

public class EquiposConMasPartidosGanadosCommand implements Runnable {

    @Override
    public void run() {
        PartidoDeCopaHome pc = new PartidoDeCopaHome();
        ArrayList<Equipo> equipos = pc.getPartidosDeCopaGanadosPorEquipo();
        System.out.println(equipos);
    }
}
