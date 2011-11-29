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
    
    Jugador jugadorAr;
    Jugador jugadorVe;

    Titular titularE;
    Titular titularV;
    Titular titularD;

    @Override
    protected void setUp() {

        this.formacion = createMock(Formacion.class);
        this.equipo = createMock(Equipo.class);
        
        this.jugadorAr = createMock(Jugador.class);
        this.jugadorVe = createMock(Jugador.class);

        this.posiciones = new ArrayList<Posicion>();
        this.titulares = new ArrayList<Titular>();
        this.jugadores = new ArrayList<Jugador>();

        this.posiciones.add(Posicion.ARQUERO);
        this.posiciones.add(Posicion.LATERAL);
        this.posiciones.add(Posicion.VOLANTE_DEFENSIVO);

        this.formacionImp = new FormacionStrategyImp(this.posiciones);

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
        expect(this.titularE.getPosicion()).andReturn(Posicion.ARQUERO).once();

        expect(this.jugadorAr.getValor(Posicion.ARQUERO)).andReturn(6).times(2);
        expect(this.jugadorVe.getValor(Posicion.ARQUERO)).andReturn(10).times(2);
       

        replay(this.titularE);
        replay(this.jugadorAr);
        replay(this.jugadorVe);
       

        Assert.assertEquals(this.titularE.getJugador(),
                this.formacionImp.buscarMJugador(this.jugadores, Posicion.ARQUERO).getJugador());
        Assert.assertEquals(this.titularE.getPosicion(),
                this.formacionImp.buscarMJugador(this.jugadores, Posicion.ARQUERO).getPosicion());

        verify(this.titularE);
        verify(this.jugadorAr);
        verify(this.jugadorVe);
    }

    public void testbuscarTitulares() {

        expect(this.jugadorAr.getValor(Posicion.ARQUERO)).andReturn(6).once();
        expect(this.jugadorVe.getValor(Posicion.ARQUERO)).andReturn(10).once();

        expect(this.jugadorAr.getValor(Posicion.LATERAL)).andReturn(10).once();
        expect(this.jugadorVe.getValor(Posicion.LATERAL)).andReturn(5).once();

        expect(this.jugadorAr.getValor(Posicion.VOLANTE_DEFENSIVO)).andReturn(0).once();
        expect(this.jugadorVe.getValor(Posicion.VOLANTE_DEFENSIVO)).andReturn(7).once();

        expect(this.formacion.getTitulares()).andReturn(this.titulares).times(5);

        replay(this.jugadorAr);
        replay(this.jugadorVe);

        replay(this.formacion);

        Assert.assertEquals(this.formacion.getTitulares(),
                this.formacionImp.buscarTitulares(this.formacion, this.jugadores).getTitulares());

        verify(this.formacion);
        verify(this.jugadorAr);
        verify(this.jugadorVe);

    }

    public void testArmarFormacion() {

        expect(this.equipo.getJugadores()).andReturn(this.jugadores).times(2);

        expect(this.jugadorAr.getValor(Posicion.ARQUERO)).andReturn(7).once();
        expect(this.jugadorVe.getValor(Posicion.ARQUERO)).andReturn(5).once();

        expect(this.jugadorAr.getValor(Posicion.LATERAL)).andReturn(0).once();
        expect(this.jugadorVe.getValor(Posicion.LATERAL)).andReturn(9).once();

        expect(this.jugadorAr.getValor(Posicion.VOLANTE_DEFENSIVO)).andReturn(9).once();
        expect(this.jugadorVe.getValor(Posicion.VOLANTE_DEFENSIVO)).andReturn(6).once();

        expect(this.formacion.getSuplente(0)).andReturn(this.jugadorVe).once();
      
        replay(this.jugadorAr);
        replay(this.jugadorVe);

        replay(this.equipo);
        replay(this.formacion);

       Assert.assertEquals(this.jugadores, this.equipo.getJugadores());
       Assert.assertEquals(this.formacion.getSuplente(0), this.formacionImp.armarFormacion(this.equipo).getSuplente(0));

        verify(this.equipo);
        verify(this.formacion);
    }
    
}
