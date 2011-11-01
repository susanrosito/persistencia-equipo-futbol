package dominio;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;

import dominio.Equipo;
import dominio.Formacion;
import dominio.FormacionStrategyImp;
import dominio.Jugador;
import dominio.Posicion;
import dominio.Titular;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestFormacionStrategyImp extends TestCase {

    Formacion formacion;

    Equipo equipo;

    FormacionStrategyImp formacionImp;

    ArrayList<Jugador> jugadores;

    ArrayList<Posicion> posiciones;

    ArrayList<Titular> titulares;

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
        this.titulares = new ArrayList<Titular>();
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

        this.titulares.add(this.titularE);
        this.titulares.add(this.titularD);
        this.titulares.add(this.titularV);
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

        expect(this.formacion.getTitulares()).andReturn(this.titulares).times(5);

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

        expect(this.equipo.getJugadores()).andReturn(this.jugadores).times(2);

        expect(this.jugadorAr.getValor(this.posicion.ARQUERO)).andReturn(7).once();
        expect(this.jugadorVe.getValor(this.posicion.ARQUERO)).andReturn(5).once();
        expect(this.jugadorDe.getValor(this.posicion.ARQUERO)).andReturn(9).once();
        expect(this.jugadorNy.getValor(this.posicion.ARQUERO)).andReturn(1).once();

        expect(this.jugadorAr.getValor(this.posicion.LATERAL)).andReturn(0).once();
        expect(this.jugadorVe.getValor(this.posicion.LATERAL)).andReturn(9).once();
        expect(this.jugadorDe.getValor(this.posicion.LATERAL)).andReturn(2).once();
        expect(this.jugadorNy.getValor(this.posicion.LATERAL)).andReturn(6).once();

        expect(this.jugadorAr.getValor(this.posicion.VOLANTE_DEFENSIVO)).andReturn(9).once();
        expect(this.jugadorVe.getValor(this.posicion.VOLANTE_DEFENSIVO)).andReturn(6).once();
        expect(this.jugadorDe.getValor(this.posicion.VOLANTE_DEFENSIVO)).andReturn(4).once();
        expect(this.jugadorNy.getValor(this.posicion.VOLANTE_DEFENSIVO)).andReturn(7).once();

        expect(this.formacion.getSuplente(0)).andReturn(this.jugadorNy).once();

        replay(this.jugadorAr);
        replay(this.jugadorVe);
        replay(this.jugadorDe);
        replay(this.jugadorNy);

        replay(this.equipo);
        replay(this.formacion);

        Assert.assertEquals(this.jugadores, this.equipo.getJugadores());
        // Assert.assertEquals(this.formacion.getTitulares(),
        // this.formacionImp.armarFormacion(this.equipo).getTitulares());
        Assert.assertEquals(this.formacion.getSuplente(0), this.formacionImp.armarFormacion(this.equipo).getSuplente(0));

        verify(this.equipo);
        verify(this.formacion);

    }
}
