package commands;

import homes.PartidoDeCopaHome;

import java.util.List;

import dominio.Equipo;

public class EquiposConMasPartidosGanadosCommand implements Runnable {

    @Override
    public void run() {
        PartidoDeCopaHome pc = new PartidoDeCopaHome();
        List<Equipo> equipos = pc.getPartidosDeCopaGanadosPorEquipo();
        System.out.println(equipos.size());
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println(equipos.get(i).getNombre());
        }
    }
}
