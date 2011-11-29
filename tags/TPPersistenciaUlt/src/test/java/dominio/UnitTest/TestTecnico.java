package dominio.UnitTest;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import dominio.FormacionStrategyImp;
import dominio.Tecnico;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestTecnico extends TestCase {
    FormacionStrategyImp formacionStrategy;
    String nombre;
    Tecnico tec;

    @Override
    protected void setUp() {
        this.formacionStrategy = createMock(FormacionStrategyImp.class);
        this.nombre = "Domingo Augusto";
        this.tec = new Tecnico(this.nombre, this.formacionStrategy);
    }

    @Override
    protected void tearDown() {
        this.formacionStrategy = null;
        this.nombre = null;
        this.tec = null;
    }

    public void testTecnico() {
        Assert.assertEquals(this.nombre, this.tec.getNombre());
        Assert.assertEquals(this.formacionStrategy, this.tec.getFormacionStrategy());
    }

    public void testArmarFormacion() {
        expect(this.formacionStrategy.armarFormacion(null)).andReturn(null).once();
        replay(this.formacionStrategy);
        this.tec.armarFormacion(null);
        verify(this.formacionStrategy);

    }

    public void testGetNombre() {

        Assert.assertEquals(this.nombre, this.tec.getNombre());
    }

}
