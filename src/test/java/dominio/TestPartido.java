package dominio;

import static org.easymock.EasyMock.createMock;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestPartido extends TestCase {
    Equipo equipoA;

    Equipo equipoB;

    Partido partido;

    @Override
    protected void setUp() {
        this.equipoA = createMock(Equipo.class);
        this.equipoB = createMock(Equipo.class);
        this.partido = new Partido(this.equipoA, this.equipoB);
        this.partido.setGolesEquipoA(3);
        this.partido.setGolesEquipoB(2);
    }

    public void testGanador() {
        Assert.assertEquals(this.equipoA, this.partido.getGanadorP());
        // partido empatado
        this.partido.setGolesEquipoA(2);
        Assert.assertNull(this.partido.getGanadorP());
    }
}
