package Tests;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;
import Clases.HabilidadImp;
import Clases.Jugador;
import Clases.Posicion;

public class TestJugador extends TestCase {
    String nombre;

    HabilidadImp mockHab1;

    HabilidadImp mockHab2;

    HabilidadImp mockHab3;

    Set<HabilidadImp> habilidades;

    Jugador jugador;

    @Override
    protected void setUp() {
        this.nombre = "Lalo Landa";
        this.mockHab1 = createMock(HabilidadImp.class);
        this.mockHab2 = createMock(HabilidadImp.class);
        this.mockHab3 = createMock(HabilidadImp.class);
        this.habilidades = new HashSet<HabilidadImp>();
        this.habilidades.add(this.mockHab1);
        this.habilidades.add(this.mockHab2);
        this.habilidades.add(this.mockHab3);
        this.jugador = new Jugador(this.nombre, this.habilidades);
    }

    public void testGetValor() {
        expect(this.mockHab1.getValor(Posicion.DELANTERO)).andReturn(8);
        expect(this.mockHab1.getValor(Posicion.LATERAL)).andReturn(0);
        expect(this.mockHab1.getValor(Posicion.CENTRAL)).andReturn(0);
        expect(this.mockHab1.getValor(Posicion.MEDIA_PUNTA)).andReturn(0);
        expect(this.mockHab2.getValor(Posicion.LATERAL)).andReturn(3);
        expect(this.mockHab2.getValor(Posicion.DELANTERO)).andReturn(0);
        expect(this.mockHab2.getValor(Posicion.CENTRAL)).andReturn(0);
        expect(this.mockHab2.getValor(Posicion.MEDIA_PUNTA)).andReturn(0);
        expect(this.mockHab3.getValor(Posicion.CENTRAL)).andReturn(5);
        expect(this.mockHab3.getValor(Posicion.DELANTERO)).andReturn(0);
        expect(this.mockHab3.getValor(Posicion.MEDIA_PUNTA)).andReturn(0);
        expect(this.mockHab3.getValor(Posicion.LATERAL)).andReturn(0);

        replay(this.mockHab1);
        replay(this.mockHab2);
        replay(this.mockHab3);

        Assert.assertEquals(8, this.jugador.getValor(Posicion.DELANTERO));
        Assert.assertEquals(3, this.jugador.getValor(Posicion.LATERAL));
        Assert.assertEquals(5, this.jugador.getValor(Posicion.CENTRAL));
        Assert.assertEquals(0, this.jugador.getValor(Posicion.MEDIA_PUNTA));

        verify(this.mockHab1);
        verify(this.mockHab2);
        verify(this.mockHab3);

    }

}
