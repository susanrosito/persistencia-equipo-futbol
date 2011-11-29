package dominio.UnitTest;

import interfaces.Habilidad;
import dominio.HabilidadImp;
import dominio.Posicion;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestHabilidadImp extends TestCase {
	Posicion posicion;
	int valor;
	Habilidad habilidad;

	protected void setUp() {
		this.posicion = Posicion.ARQUERO;
		this.valor = 6;
		this.habilidad = new HabilidadImp(this.posicion, this.valor);
	}

	public void testGetValor() {
		Assert.assertEquals(0, this.habilidad.getValor(Posicion.CENTRAL));
		Assert.assertEquals(6, this.habilidad.getValor(Posicion.ARQUERO));
	}

}
