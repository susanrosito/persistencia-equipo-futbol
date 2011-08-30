package Tests;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;
import Clases.Equipo;
import Clases.Formacion;
import Clases.FormacionStrategyImp;
import Clases.Jugador;
import Clases.Posicion;
import Clases.Titular;

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

    Titular titularE;

    Titular titularV;

    Titular titularD;

    @Override
    protected void setUp() {

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
        this.posiciones.add(this.posicion.LATERAL);
        this.posiciones.add(this.posicion.VOLANTE_DEFENSIVO);

        this.formacionImp = new FormacionStrategyImp(this.posiciones);

        this.jugadores.add(this.jugadorDe);
        this.jugadores.add(this.jugadorNy);
        this.jugadores.add(this.jugadorVe);
        this.jugadores.add(this.jugadorAr);

        this.titularE = createMock(Titular.class);
        this.titularD = createMock(Titular.class);
        this.titularV = createMock(Titular.class);

    }

    @Override
    protected void tearDown() throws Exception {

        this.formacion = null;
        this.titularE = null;
    }

    public void testFormacionStrategyImp() {

        Assert.assertEquals(this.posiciones, this.formacionImp.getPosiciones());

    }

    public void testBuscarMJugador() {

        expect(this.titularE.getJugador()).andReturn(this.jugadorVe).once();
        expect(this.titularE.getPosicion()).andReturn(this.posicion.ARQUERO).once();

        expect(this.jugadorAr.getValor(this.posicion.ARQUERO)).andReturn(6).times(2);
        expect(this.jugadorVe.getValor(this.posicion.ARQUERO)).andReturn(10).times(2);
        expect(this.jugadorDe.getValor(this.posicion.ARQUERO)).andReturn(2).times(2);
        expect(this.jugadorNy.getValor(this.posicion.ARQUERO)).andReturn(9).times(2);

        replay(this.titularE);
        replay(this.jugadorAr);
        replay(this.jugadorVe);
        replay(this.jugadorDe);
        replay(this.jugadorNy);

        Assert.assertEquals(this.titularE.getJugador(),
                this.formacionImp.buscarMJugador(this.jugadores, this.posicion.ARQUERO).getJugador());
        Assert.assertEquals(this.titularE.getPosicion(),
                this.formacionImp.buscarMJugador(this.jugadores, this.posicion.ARQUERO).getPosicion());

        verify(this.titularE);
        verify(this.jugadorAr);
        verify(this.jugadorVe);
        verify(this.jugadorDe);
        verify(this.jugadorNy);
    }

    public void testbuscarTitulares() {

        expect(this.jugadorAr.getValor(this.posicion.ARQUERO)).andReturn(6).once();
        expect(this.jugadorVe.getValor(this.posicion.ARQUERO)).andReturn(10).once();
        expect(this.jugadorDe.getValor(this.posicion.ARQUERO)).andReturn(2).once();
        expect(this.jugadorNy.getValor(this.posicion.ARQUERO)).andReturn(9).once();

        expect(this.jugadorAr.getValor(this.posicion.LATERAL)).andReturn(10).once();
        expect(this.jugadorVe.getValor(this.posicion.LATERAL)).andReturn(5).once();
        expect(this.jugadorDe.getValor(this.posicion.LATERAL)).andReturn(8).once();
        expect(this.jugadorNy.getValor(this.posicion.LATERAL)).andReturn(6).once();

        expect(this.jugadorAr.getValor(this.posicion.VOLANTE_DEFENSIVO)).andReturn(0).once();
        expect(this.jugadorVe.getValor(this.posicion.VOLANTE_DEFENSIVO)).andReturn(7).once();
        expect(this.jugadorDe.getValor(this.posicion.VOLANTE_DEFENSIVO)).andReturn(10).once();
        expect(this.jugadorNy.getValor(this.posicion.VOLANTE_DEFENSIVO)).andReturn(4).once();

        expect(this.formacion.getTitulares()).times(4);

        replay(this.jugadorAr);
        replay(this.jugadorVe);
        replay(this.jugadorDe);
        replay(this.jugadorNy);

        replay(this.formacion);

        Assert.assertEquals(this.formacion.getTitulares(),
                this.formacionImp.buscarTitulares(this.formacion, this.jugadores).getTitulares());

        verify(this.formacion);
        verify(this.jugadorAr);
        verify(this.jugadorVe);
        verify(this.jugadorDe);
        verify(this.jugadorNy);

    }

    public void testArmarFormacion() {

    }

}
