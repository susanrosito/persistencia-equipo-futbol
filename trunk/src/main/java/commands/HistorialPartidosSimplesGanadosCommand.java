package commands;

import homes.PartidoSimpleHome;

/**
 * TODO: description
 */
public class HistorialPartidosSimplesGanadosCommand implements Runnable {

    private final String nombreEquipoA;
    private final String nombreEquipoB;

    public HistorialPartidosSimplesGanadosCommand(final String equipoA, final String equipoB) {
        this.nombreEquipoA = equipoA;
        this.nombreEquipoB = equipoB;
    }

    @Override
    public void run() {
        int cantidadPartidosGandosEquipoAL = new PartidoSimpleHome().getCantPartidosSimplesLocalesGanadosPor(
                this.nombreEquipoA, this.nombreEquipoB);
        int cantidadPartidosGanadosEquipoAV = new PartidoSimpleHome().getCantPartidosSimplesVisitantesGanadosPor(
                this.nombreEquipoA, this.nombreEquipoB);
        int total = cantidadPartidosGandosEquipoAL + cantidadPartidosGanadosEquipoAV;

        int empate = new PartidoSimpleHome().getCantPartidosSimplesEmpatadosEntre(this.nombreEquipoA,
                this.nombreEquipoB);
        System.out.println("Cantidad de partidos ganados del " + this.nombreEquipoA + " son " + total);
        System.out.println("Partidos empatados " + empate);

    }

}
