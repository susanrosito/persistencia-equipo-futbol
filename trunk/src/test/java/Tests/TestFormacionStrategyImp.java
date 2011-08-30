package Tests;

import static org.easymock.EasyMock.createMock;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;
import Clases.Equipo;
import Clases.Formacion;
import Clases.FormacionStrategyImp;
import Clases.Jugador;
import Clases.Posicion;

public class TestFormacionStrategyImp extends TestCase {

    Formacion formacion;

    Equipo equipo;

    FormacionStrategyImp formacionImp;

    ArrayList<Jugador> jugadores;

    ArrayList<Posicion> posiciones;

    Posicion posicion;

    Jugador jugadorEn;

    Jugador jugadorUr;

    Jugador jugadorAr;

    Jugador jugadorVe;

    Jugador jugadorSe;

    Jugador jugadorDe;

    Jugador jugadorNy;

    Jugador jugadorTi;

    @Override
    protected void setUp() throws Exception {

        this.formacion = createMock(Formacion.class);

        this.equipo = createMock(Equipo.class);

        this.jugadorAr = createMock(Jugador.class);
        this.jugadorDe = createMock(Jugador.class);
        this.jugadorEn = createMock(Jugador.class);
        this.jugadorNy = createMock(Jugador.class);
        this.jugadorSe = createMock(Jugador.class);
        this.jugadorTi = createMock(Jugador.class);
        this.jugadorUr = createMock(Jugador.class);
        this.jugadorVe = createMock(Jugador.class);

        this.posiciones = new ArrayList<Posicion>();

        this.jugadores = new ArrayList<Jugador>();

        this.posiciones.add(this.posicion.ARQUERO);
        this.posiciones.add(this.posicion.CENTRAL);
        this.posiciones.add(this.posicion.DELANTERO);
        this.posiciones.add(this.posicion.ENGANCHE);
        this.posiciones.add(this.posicion.LATERAL);
        this.posiciones.add(this.posicion.MEDIA_PUNTA);
        this.posiciones.add(this.posicion.VOLANTE_DEFENSIVO);
        this.posiciones.add(this.posicion.VOLANTE_LATERAL);

        this.formacionImp = new FormacionStrategyImp(this.posiciones);

        this.jugadores.add(this.jugadorDe);
        this.jugadores.add(this.jugadorEn);
        this.jugadores.add(this.jugadorSe);
        this.jugadores.add(this.jugadorNy);
        this.jugadores.add(this.jugadorVe);
        this.jugadores.add(this.jugadorAr);
        this.jugadores.add(this.jugadorTi);
        this.jugadores.add(this.jugadorUr);

    }

    @Override
    protected void tearDown() throws Exception {

        this.formacion = null;
    }

    public void testFormacionStrategyImp() {

        Assert.assertEquals(this.posiciones, this.formacionImp.getPosiciones());

    }

    public void testBuscarMJugador() {

        this.formacionImp.buscarMJugador(this.jugadores, this.posicion.ARQUERO);

    }

    public void testbuscarTitulares() {

    }

    public void testArmarFormacion() {

    }

}
